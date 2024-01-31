package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.CacheDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie

interface MoviesCacheDataSources {

    suspend fun getMoviesFromCache():List<Movie>

    suspend fun saveMoviestoCache(movies:List<Movie>)

}