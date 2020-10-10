package com.anushka.tmdbclient.network.di.tvShow

import com.anushka.tmdbclient.view.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}