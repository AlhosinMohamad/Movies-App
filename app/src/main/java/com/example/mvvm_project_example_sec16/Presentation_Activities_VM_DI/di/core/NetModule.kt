package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.api.TmdbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl:String) {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

   @Singleton
   @Provides
   fun provideTmdbServices(retrofit: Retrofit):TmdbService{
       return retrofit.create(TmdbService::class.java)
   }

}