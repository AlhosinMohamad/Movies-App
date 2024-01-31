package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.CacheDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist

interface ArtistCasheDataSource {

    suspend fun getArtistFromCache():List<Artist>

    suspend fun saveArtistToCache(artists:List<Artist>)
}