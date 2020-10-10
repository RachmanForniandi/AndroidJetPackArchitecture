package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.domain.repositories.TvShow.datasourceImpl.TvShowRepositoryImpl
import com.anushka.tmdbclient.domain.repositories.artist.ArtistRepository
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl.ArtistRepositoryImpl
import com.anushka.tmdbclient.domain.repositories.movies.MovieRepository
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieLocalDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl.MovieRepositoryImpl
import com.anushka.tmdbclient.domain.repositories.tvShows.TvShowRepository
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowCacheDataSource
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowLocalDataSource
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(tvShowRemoteDataSource: TvShowRemoteDataSource,
                               tvShowLocalDataSource: TvShowLocalDataSource,
                                tvShowCacheDataSource: TvShowCacheDataSource): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(artistRemoteDataSource: ArtistRemoteDataSource,
                               artistLocalDataSource: ArtistLocalDataSource,
                                artistCacheDataSource: ArtistCacheDataSource): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource
        )
    }


}