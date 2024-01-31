package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.RemoteDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.api.TmdbService
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl (private val tmdbService: TmdbService,private val apiKey:String) :
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getpobularMovies(apiKey = apiKey)
    }

}