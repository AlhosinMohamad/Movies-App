package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.CacheDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show

interface TvShowCacheDataSource {

    suspend fun getAllTvShowsFromCache():List<TV_Show>

    suspend fun saveTvShowsToCache(tvShowsList:List<TV_Show>)
}