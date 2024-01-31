package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie

import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MovieSubComponent
    }
}