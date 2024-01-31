package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import android.content.Context
import androidx.room.Room
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.ArtistsDao
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.MovieDao
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.RoomTmdbDatabase
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):RoomTmdbDatabase{
        return Room.databaseBuilder(context,RoomTmdbDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: RoomTmdbDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: RoomTmdbDatabase):TvShowsDao{
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistsDao(tmdbDatabase: RoomTmdbDatabase):ArtistsDao{
        return tmdbDatabase.artistDao()
    }
}