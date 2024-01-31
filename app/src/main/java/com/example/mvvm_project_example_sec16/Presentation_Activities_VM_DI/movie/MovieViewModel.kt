package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.GetMoviesUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase:GetMoviesUseCase,
    private val updateMoviesUseCase:UpdateMoviesUseCase
):ViewModel() {
    fun getMovies()= liveData {
        val moviesList=getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updatMovies() = liveData{
        val moviesList=updateMoviesUseCase.execute()
        emit(moviesList)
    }
}