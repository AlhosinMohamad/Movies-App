package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.GetArtistsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.UpdateArtistUseCase

class ArtistViewModelFactory (
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase,updateArtistUseCase) as T
    }
}