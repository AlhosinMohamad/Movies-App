package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.ArtistRepositoryIMPL
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.CacheDataSource.ArtistCasheDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.LocalDataSource.ArtistLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.RemoteDataSource.ArtistRemoteDataSourse
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.CacheDataSource.MoviesCacheDataSources
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.LocalDataSource.MovieLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.MovieRepositoryIMPL
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.RemoteDataSource.MovieRemoteDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.CacheDataSource.TvShowCacheDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.LocalDataSoursce.TvShowLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.RemoteDataSource.TvShowRemoteDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.TvShowsRepositoryIMPL
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.ArtistsRepository
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Movies_Usecases.MovieRepository
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        moviesCacheDataSources: MoviesCacheDataSources
    ):MovieRepository{
        return MovieRepositoryIMPL(
            movieRemoteDataSource,
            movieLocalDataSource,
            moviesCacheDataSources
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSources: TvShowCacheDataSource
    ):TvShowsRepository{
        return TvShowsRepositoryIMPL(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSources
        )
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSourse,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSources: ArtistCasheDataSource
    ):ArtistsRepository{
        return ArtistRepositoryIMPL(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSources
        )
    }
}