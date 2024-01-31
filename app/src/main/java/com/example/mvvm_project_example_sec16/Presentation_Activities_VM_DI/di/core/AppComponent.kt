package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.artist.ArtistSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie.MovieSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemotDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}