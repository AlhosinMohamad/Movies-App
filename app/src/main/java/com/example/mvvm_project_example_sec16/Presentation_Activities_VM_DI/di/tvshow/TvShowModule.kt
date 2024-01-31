package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.tvshow

import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.GetTvShowsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.UpdateTvShowsUseCase
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie.MovieScope
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase,updateTvShowsUseCase)
    }
}