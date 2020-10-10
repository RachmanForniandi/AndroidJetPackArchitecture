package com.anushka.tmdbclient.network.di.artist

import com.anushka.tmdbclient.view.ArtistActivity
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