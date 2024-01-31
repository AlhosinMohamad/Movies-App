package com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show

interface TvShowsRepository {

    suspend fun getTvShows():List<TV_Show>?

    suspend fun updateTvShows():List<TV_Show>?
}