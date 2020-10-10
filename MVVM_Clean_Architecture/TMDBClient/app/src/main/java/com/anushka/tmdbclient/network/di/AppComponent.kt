package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.network.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.network.di.movie.MovieSubComponent
import com.anushka.tmdbclient.network.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory

}