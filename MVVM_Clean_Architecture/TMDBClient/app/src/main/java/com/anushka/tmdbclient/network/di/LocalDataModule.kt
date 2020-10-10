package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl.TvShowLocalDataSourceImpl
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl.MovieLocalDataSourceImpl
import com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl.MovieRemoteDataResourceImpl
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowLocalDataSource
import com.anushka.tmdbclient.local.ArtistDao
import com.anushka.tmdbclient.local.MovieDao
import com.anushka.tmdbclient.local.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }


}