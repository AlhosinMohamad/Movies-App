package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di

import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.artist.ArtistSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie.MovieSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}