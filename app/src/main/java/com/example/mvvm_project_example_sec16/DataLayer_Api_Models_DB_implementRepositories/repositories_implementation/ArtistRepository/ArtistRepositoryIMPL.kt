package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository

import android.util.Log
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.CacheDataSource.ArtistCasheDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.LocalDataSource.ArtistLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.ArtistRepository.RemoteDataSource.ArtistRemoteDataSourse
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Artists_Usecases.ArtistsRepository

class ArtistRepositoryIMPL(


    private val artistRemoteDataSource: ArtistRemoteDataSourse,
    private val artistLocalDataSource:ArtistLocalDataSource,
    private val artistCachDataSource: ArtistCasheDataSource
) :ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val artistList=getArtistsFromAPI()

        artistLocalDataSource.clearAllArtist()
        artistLocalDataSource.saveArtistToDB(artistList)
        artistCachDataSource.saveArtistToCache(artistList)

        return artistList
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>

        try{
            val response = artistRemoteDataSource.getAllartistFromAPI()
            val body=response.body()

            if(body!=null){
                artistList=body.artists
            }
        }catch (e:Exception){
            Log.i("MYEXCEPTION",e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistsList:List<Artist>

        try {
            artistsList=artistLocalDataSource.getAllArtistFromDB()

        }catch (e:Exception){
            Log.i("MYException",e.message.toString())
        }

        if(artistsList.size>0){
            return artistsList
        }else{
            artistsList=getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistsList)
        }
        return artistsList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistsList: List<Artist>

        try {
            artistsList=artistCachDataSource.getArtistFromCache()
        }catch (e:Exception){
            Log.i("MyExcption",e.message.toString())
        }

        if(artistsList.size>0){

            return artistsList

        }else{
           artistsList=getArtistsFromDB()
           artistCachDataSource.saveArtistToCache(artistsList)
        }

        return artistsList
    }


}