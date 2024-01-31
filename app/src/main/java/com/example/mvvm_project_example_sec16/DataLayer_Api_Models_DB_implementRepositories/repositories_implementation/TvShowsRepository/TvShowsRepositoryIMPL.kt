package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository

import android.util.Log
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.CacheDataSource.TvShowCacheDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.LocalDataSoursce.TvShowLocalDataSource
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.repositories_implementation.TvShowsRepository.RemoteDataSource.TvShowRemoteDataSource
import com.example.mvvm_project_example_sec16.DomainLayer_UseCases_Repositories.Tvshows_Usecases.TvShowsRepository

class TvShowsRepositoryIMPL(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TV_Show>? {
        return getShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TV_Show>? {
        val newtvShowslist=getTvShowsFromAPI()

        tvShowLocalDataSource.clearAllTvShows()
        tvShowLocalDataSource.saveTvShowsToDB(newtvShowslist)
        tvShowCacheDataSource.saveTvShowsToCache(newtvShowslist)

        return newtvShowslist
    }

    suspend fun getTvShowsFromAPI():List<TV_Show>{
        lateinit var tvShowsList: List<TV_Show>

        try {
            val response=tvShowRemoteDataSource.getAlltvShowsFromAPI()
            val body=response.body()
            if(body!=null){
                tvShowsList=body.TVShows
            }
        }catch (exception:Exception){
            Log.i("MyException",exception.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB():List<TV_Show>{
        lateinit var tvShows:List<TV_Show>

        try {
            tvShows=tvShowLocalDataSource.getAllTvShowsfromDB()
        }catch (e:Exception){
            Log.i("MyExcption",e.message.toString())
        }

        if (tvShows.size>0){
            return tvShows
        }else{
            tvShows=getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShows)
        }

        return tvShows
    }

    suspend fun getShowsFromCache():List<TV_Show>{
        lateinit var tvShowlist:List<TV_Show>

        try {
            tvShowlist=tvShowCacheDataSource.getAllTvShowsFromCache()
        }catch (e:Exception){
            Log.i("MyException",e.message.toString())
        }

        if (tvShowlist.size>0){
            return tvShowlist
        }else{
            tvShowlist=getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowlist)
        }
        return tvShowlist
    }
}