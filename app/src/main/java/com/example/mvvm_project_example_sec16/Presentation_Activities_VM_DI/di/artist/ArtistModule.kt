package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.artist

import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.GetArtistsUseCase
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.UpdateArtistUseCase
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactor(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase,updateArtistUseCase)
    }
}