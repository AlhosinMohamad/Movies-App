package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.GetArtistsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistuseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel(){

    fun getArtist()= liveData{
        val artistList=getArtistuseCase.execute()
        emit(artistList)
    }

    fun updateArtist()= liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }

}