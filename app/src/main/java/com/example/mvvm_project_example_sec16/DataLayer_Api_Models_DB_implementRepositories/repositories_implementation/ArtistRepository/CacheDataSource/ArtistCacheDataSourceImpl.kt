package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.CacheDataSource

import android.os.Parcel
import android.os.Parcelable
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist

class ArtistCacheDataSourceImpl() :ArtistCasheDataSource {
    var artistsCachedList=ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistsCachedList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistsCachedList.clear()
        artistsCachedList=ArrayList(artists)
    }

}