package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.GetTvShowsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.UpdateTvShowsUseCase

class TvshowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {
    fun getTvShows()= liveData {
        val tvShowsList= getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShow() = liveData {
        val tvShowsList=updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}