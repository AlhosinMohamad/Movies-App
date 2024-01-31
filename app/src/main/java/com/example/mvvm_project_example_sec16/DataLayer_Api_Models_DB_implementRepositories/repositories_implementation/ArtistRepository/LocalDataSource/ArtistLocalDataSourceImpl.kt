package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.LocalDataSource

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.room_db.ArtistsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao:ArtistsDao) : ArtistLocalDataSource {

    override suspend fun getAllArtistFromDB(): List<Artist> {
        return artistDao.getAllArtist()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch{
            artistDao.saveArtists(artist)
        }

    }

    override suspend fun clearAllArtist() {
        CoroutineScope(Dispatchers.IO).launch{
            artistDao.deleteAllArtist()
        }

    }

}