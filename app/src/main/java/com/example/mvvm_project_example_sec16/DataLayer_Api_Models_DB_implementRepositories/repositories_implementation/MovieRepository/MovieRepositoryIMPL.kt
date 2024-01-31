package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository

import android.util.Log
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.LocalDataSource.MovieLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.RemoteDataSource.MovieRemoteDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.CacheDataSource.MoviesCacheDataSources
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.MovieRepository
import java.lang.Exception

class MovieRepositoryIMPL(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val moviesCacheDataSources: MoviesCacheDataSources

) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListofMovies= getMoviesFromAPI()

        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListofMovies)
        moviesCacheDataSources.saveMoviestoCache(newListofMovies)

        return newListofMovies

    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {

            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }


        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }


        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList: List<Movie>

        try {
            movieList = moviesCacheDataSources.getMoviesFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }

        if(movieList.size>0){
            return movieList
        }else{
            movieList=getMoviesFromDB()
            moviesCacheDataSources.saveMoviestoCache(movieList)
        }


        return movieList
    }


}