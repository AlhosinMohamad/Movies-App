package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.tvshow

import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}