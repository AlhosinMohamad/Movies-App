package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.LocalDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist

interface ArtistLocalDataSource {

    suspend fun getAllArtistFromDB():List<Artist>

    suspend fun saveArtistToDB(artist:List<Artist>)

    suspend fun clearAllArtist()

}