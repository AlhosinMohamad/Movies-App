package com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?

    suspend fun updateMovies():List<Movie>?
}