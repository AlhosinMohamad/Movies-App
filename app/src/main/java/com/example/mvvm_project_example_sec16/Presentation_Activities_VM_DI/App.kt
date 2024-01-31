package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI

import android.app.AppComponentFactory
import android.app.Application
import com.example.mvvm_project_example_sec16.BuildConfig
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.Injector
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.artist.ArtistSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core.AppComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core.AppModule
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core.DaggerAppComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core.NetModule
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.core.RemotDataModule
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie.MovieSubComponent
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.tvshow.TvShowSubComponent
import dagger.android.support.DaggerAppCompatActivity
import dagger.internal.DaggerCollections
import dagger.internal.DaggerGenerated

class App:Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent= DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remotDataModule(RemotDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}