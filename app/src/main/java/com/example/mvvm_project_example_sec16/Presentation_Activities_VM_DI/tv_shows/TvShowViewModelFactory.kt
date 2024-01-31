package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.GetTvShowsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.UpdateTvShowsUseCase

class TvShowViewModelFactory (
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvshowViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
    }

}