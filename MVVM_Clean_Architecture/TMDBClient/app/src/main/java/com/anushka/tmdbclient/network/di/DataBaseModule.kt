package com.anushka.tmdbclient.network.di

import android.content.Context
import androidx.room.Room
import com.anushka.tmdbclient.local.ArtistDao
import com.anushka.tmdbclient.local.MovieDao
import com.anushka.tmdbclient.local.TMDBLocalDatabase
import com.anushka.tmdbclient.local.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieLocalDatabase(context: Context):TMDBLocalDatabase{
        return Room.databaseBuilder(context,
            TMDBLocalDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbLocalDatabase: TMDBLocalDatabase):MovieDao{
        return tmdbLocalDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbLocalDatabase: TMDBLocalDatabase):TvShowDao{
        return tmdbLocalDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbLocalDatabase: TMDBLocalDatabase):ArtistDao{
        return tmdbLocalDatabase.artistDao()
    }



}