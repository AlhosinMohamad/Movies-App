package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.ArtistsRepository
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.GetArtistsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.UpdateArtistUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.GetMoviesUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.MovieRepository
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.UpdateMoviesUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.GetTvShowsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.TvShowsRepository
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(moviesRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(moviesRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCase(moviesRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)
    }

    //----------------------------------------
    @Provides
    fun provideGetTvShowUseCas(tvShowRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCas(tvShowRepository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    //----------------------------------------
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistsRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistsRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}