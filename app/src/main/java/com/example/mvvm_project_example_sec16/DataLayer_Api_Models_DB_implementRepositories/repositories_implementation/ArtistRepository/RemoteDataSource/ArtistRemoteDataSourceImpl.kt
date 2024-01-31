package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.RemoteDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.api.TmdbService
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TmdbService,
    private val apiKey: String

) : ArtistRemoteDataSourse {

    override suspend fun getAllartistFromAPI(): Response<ArtistList> {
        return tmdbService.getArtistList(apiKey = apiKey)
    }

}