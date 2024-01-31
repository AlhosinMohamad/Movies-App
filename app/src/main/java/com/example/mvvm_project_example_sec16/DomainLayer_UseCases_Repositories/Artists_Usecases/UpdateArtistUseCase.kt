package com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist

class UpdateArtistUseCase(private val artistsRepository: ArtistsRepository) {

    suspend fun execute():List<Artist>? = artistsRepository.updateArtist()
}