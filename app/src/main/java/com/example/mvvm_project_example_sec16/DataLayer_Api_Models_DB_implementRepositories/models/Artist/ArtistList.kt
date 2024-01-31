package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    //"https://api.themoviedb.org/3/person/popular?language=en-US&page=1"
    @SerializedName("results")
    val artists: List<Artist>
)