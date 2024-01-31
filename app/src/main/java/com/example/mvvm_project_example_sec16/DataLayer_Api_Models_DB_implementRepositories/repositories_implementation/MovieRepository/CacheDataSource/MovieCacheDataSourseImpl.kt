package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.CacheDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie

class MovieCacheDataSourseImpl: MoviesCacheDataSources {
    private var cachedMovieList=ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return cachedMovieList
    }

    override suspend fun saveMoviestoCache(movies: List<Movie>) {
        cachedMovieList.clear()
        cachedMovieList=ArrayList(movies)
    }
}