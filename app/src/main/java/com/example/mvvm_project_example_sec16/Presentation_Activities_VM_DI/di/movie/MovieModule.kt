package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie

import android.graphics.Movie
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.GetMoviesUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.UpdateMoviesUseCase
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }
}