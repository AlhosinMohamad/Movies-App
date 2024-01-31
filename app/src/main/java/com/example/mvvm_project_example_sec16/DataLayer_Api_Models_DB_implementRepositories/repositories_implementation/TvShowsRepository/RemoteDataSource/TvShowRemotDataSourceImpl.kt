package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.RemoteDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.api.TmdbService
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_ShowList
import retrofit2.Response

class TvShowRemotDataSourceImpl(
    private val tmdbService: TmdbService,
    private val apiKey: String
) :TvShowRemoteDataSource {
    override suspend fun getAlltvShowsFromAPI(): Response<TV_ShowList> {
       return tmdbService.getpobularTvShows(apiKey=apiKey)
    }
}