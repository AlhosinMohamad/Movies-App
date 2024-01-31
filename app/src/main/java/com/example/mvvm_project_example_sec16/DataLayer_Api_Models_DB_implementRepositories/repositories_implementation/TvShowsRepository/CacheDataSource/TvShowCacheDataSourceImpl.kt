package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.CacheDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowsCacheList=ArrayList<TV_Show>()

    override suspend fun getAllTvShowsFromCache(): List<TV_Show> {
        return tvShowsCacheList
    }

    override suspend fun saveTvShowsToCache(tvShowsList:List<TV_Show>) {
        tvShowsCacheList.clear()
        tvShowsCacheList=ArrayList(tvShowsList)
    }
}