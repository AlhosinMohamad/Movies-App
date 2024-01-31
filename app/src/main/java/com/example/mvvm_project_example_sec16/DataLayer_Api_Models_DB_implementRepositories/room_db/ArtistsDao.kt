package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist

@Dao
interface ArtistsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists:List<Artist>)

    @Query("Select * from popular_artists")
    suspend fun getAllArtist():List<Artist>

    @Query("Delete from popular_artists")
    suspend fun deleteAllArtist()
}