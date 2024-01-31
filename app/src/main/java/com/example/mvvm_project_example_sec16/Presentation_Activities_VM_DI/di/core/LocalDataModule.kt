package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.LocalDataSource.ArtistLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.LocalDataSource.ArtistLocalDataSourceImpl
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.LocalDataSource.MovieLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.MovieRepository.LocalDataSource.MovieLocalDataSourceImpl
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.LocalDataSoursce.TvShowLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.LocalDataSoursce.TvShowLocalDataSourceImpl
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.ArtistsDao
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.MovieDao
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowsDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistsDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }
}