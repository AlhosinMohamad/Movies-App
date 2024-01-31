package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.artist

import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}