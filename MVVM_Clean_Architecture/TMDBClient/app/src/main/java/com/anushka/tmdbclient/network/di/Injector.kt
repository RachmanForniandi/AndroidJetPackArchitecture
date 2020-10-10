package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.network.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.network.di.movie.MovieSubComponent
import com.anushka.tmdbclient.network.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistComponent():ArtistSubComponent

}