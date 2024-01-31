package com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist

interface ArtistsRepository {

    suspend fun getArtists():List<Artist>?

    suspend fun updateArtist():List<Artist>?

}