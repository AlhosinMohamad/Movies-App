package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.api

import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.ArtistList
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.MovieList
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_ShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("movie/popular")
    suspend fun getpobularMovies(@Query("api_key")apiKey:String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getpobularTvShows(@Query("api_key")apiKey:String): Response<TV_ShowList>

    @GET("person/popular")
    suspend fun getArtistList(@Query("api_key")apiKey:String): Response<ArtistList>
}