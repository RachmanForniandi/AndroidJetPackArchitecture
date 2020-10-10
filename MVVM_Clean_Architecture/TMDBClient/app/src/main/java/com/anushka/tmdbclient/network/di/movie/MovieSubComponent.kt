package com.anushka.tmdbclient.network.di.movie

import com.anushka.tmdbclient.network.di.artist.ArtistModule
import com.anushka.tmdbclient.network.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.view.ArtistActivity
import com.anushka.tmdbclient.view.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}