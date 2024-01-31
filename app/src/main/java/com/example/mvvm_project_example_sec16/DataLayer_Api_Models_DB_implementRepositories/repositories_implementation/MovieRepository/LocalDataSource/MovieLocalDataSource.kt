package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.LocalDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()

}