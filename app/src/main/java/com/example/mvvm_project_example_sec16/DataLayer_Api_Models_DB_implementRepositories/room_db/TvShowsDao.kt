package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show


@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows:List<TV_Show>)

    @Query("Select * from popular_tvshows")
    suspend fun getAllTvShows():List<TV_Show>

    @Query("Delete from popular_tvshows")
    suspend fun deleteAllTvShows()
}