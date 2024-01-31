package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.GetMoviesUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
    ) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T
    }
}