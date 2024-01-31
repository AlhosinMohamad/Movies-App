package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies:List<Movie>)

    @Query("Select * from popular_movies")
    suspend fun getAllMovies():List<Movie>

    @Query("Delete from popular_movies")
    suspend fun deleteAllMovies()
}