package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core

import android.content.Context
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.artist.ArtistSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie.MovieSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context:Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}