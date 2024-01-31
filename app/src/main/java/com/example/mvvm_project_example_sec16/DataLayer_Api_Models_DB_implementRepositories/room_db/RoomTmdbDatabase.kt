package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show

@Database(entities = [Movie::class, TV_Show::class, Artist::class],
    version = 1,
    exportSchema = false)
abstract class RoomTmdbDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowsDao
    abstract fun artistDao(): ArtistsDao


}