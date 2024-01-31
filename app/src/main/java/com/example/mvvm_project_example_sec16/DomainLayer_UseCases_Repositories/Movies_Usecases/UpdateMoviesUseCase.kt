package com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie

class UpdateMoviesUseCase (private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}