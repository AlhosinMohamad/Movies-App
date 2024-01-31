package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.api.TmdbService
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.RemoteDataSource.ArtistRemoteDataSourceImpl
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.RemoteDataSource.ArtistRemoteDataSourse
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.RemoteDataSource.MovieRemoteDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.RemoteDataSource.MovieRemoteDataSourceImpl
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.RemoteDataSource.TvShowRemotDataSourceImpl
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.RemoteDataSource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemotDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdb: TmdbService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdb,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdb: TmdbService): ArtistRemoteDataSourse{
        return ArtistRemoteDataSourceImpl(tmdb,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdb: TmdbService): TvShowRemoteDataSource{
        return TvShowRemotDataSourceImpl (tmdb,apiKey)
    }
}