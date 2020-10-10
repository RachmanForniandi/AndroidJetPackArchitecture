package com.anushka.tmdbclient.view

import android.app.Application
import com.anushka.tmdbclient.BuildConfig

import com.anushka.tmdbclient.network.di.*
import com.anushka.tmdbclient.network.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.network.di.movie.MovieSubComponent
import com.anushka.tmdbclient.network.di.tvShow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}