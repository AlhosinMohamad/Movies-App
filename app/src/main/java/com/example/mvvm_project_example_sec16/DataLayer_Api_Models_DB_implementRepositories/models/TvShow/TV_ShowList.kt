package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow


import com.google.gson.annotations.SerializedName

data class TV_ShowList(

    //"https://api.themoviedb.org/3/discover/tv?include_adult=false&include_null_first_air_dates=false&language=en-US&page=1&sort_by=popularity.desc"

    @SerializedName("results")
    val TVShows: List<TV_Show>
)