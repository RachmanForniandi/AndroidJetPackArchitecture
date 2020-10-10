package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.domain.repositories.TvShow.datasourceImpl.TvShowCacheDataSourceImpl
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl.MovieCacheDataSourceImpl
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowCacheDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource = MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource = TvShowCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource = ArtistCacheDataSourceImpl()
}