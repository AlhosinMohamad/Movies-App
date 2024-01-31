package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.LocalDataSoursce

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.TvShowsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowsDao: TvShowsDao) :TvShowLocalDataSource {

    override suspend fun getAllTvShowsfromDB(): List<TV_Show> {
       return tvShowsDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TV_Show>) {
        CoroutineScope(Dispatchers.IO).launch{
            tvShowsDao.saveTvShows(tvShows)
        }

    }

    override suspend fun clearAllTvShows() {
        CoroutineScope(Dispatchers.IO).launch{
            tvShowsDao.deleteAllTvShows()
        }

    }

}