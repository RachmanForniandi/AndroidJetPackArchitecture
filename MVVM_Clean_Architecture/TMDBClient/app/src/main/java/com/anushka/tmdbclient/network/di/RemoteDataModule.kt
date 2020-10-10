package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl.ArtistRemoteDataResourceImpl
import com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl.TvShowRemoteDataResourceImpl
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl.MovieRemoteDataResourceImpl
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowRemoteDataSource
import com.anushka.tmdbclient.network.APIService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(apiService: APIService):MovieRemoteDataSource{
        return MovieRemoteDataResourceImpl(apiService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(apiService: APIService):TvShowRemoteDataSource{
        return TvShowRemoteDataResourceImpl(apiService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(apiService: APIService): ArtistRemoteDataSource {
        return ArtistRemoteDataResourceImpl(apiService,apiKey)
    }
}