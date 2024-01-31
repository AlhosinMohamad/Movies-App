package com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie


import com.google.gson.annotations.SerializedName

data class MovieList(
    //"https://api.themoviedb.org/3/movie/popular?language=en-US&page=1"
    @SerializedName("results")
    val movies: List<Movie>
)