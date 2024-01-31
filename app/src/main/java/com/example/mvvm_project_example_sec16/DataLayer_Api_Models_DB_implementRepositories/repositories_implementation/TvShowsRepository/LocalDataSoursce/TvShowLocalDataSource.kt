package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.LocalDataSoursce

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show

interface TvShowLocalDataSource {

    suspend fun getAllTvShowsfromDB():List<TV_Show>

    suspend fun saveTvShowsToDB(tvShows:List<TV_Show>)

    suspend fun clearAllTvShows()
}