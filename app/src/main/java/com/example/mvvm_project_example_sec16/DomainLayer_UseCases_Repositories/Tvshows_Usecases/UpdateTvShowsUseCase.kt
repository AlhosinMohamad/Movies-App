package com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show

class UpdateTvShowsUseCase (private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute():List<TV_Show>? =tvShowsRepository.updateTvShows()

}