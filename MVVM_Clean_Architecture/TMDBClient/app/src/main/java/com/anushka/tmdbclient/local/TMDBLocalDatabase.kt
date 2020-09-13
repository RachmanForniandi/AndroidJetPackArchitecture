package com.anushka.tmdbclient.local

import androidx.room.Database

import androidx.room.RoomDatabase
import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.models.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class],version = 1,exportSchema = false)
abstract class TMDBLocalDatabase: RoomDatabase() {

    abstract fun movieDao():MovieDao
    abstract fun tvShowDao():TvShowDao
    abstract fun artistDao():ArtistDao
}