package com.anushka.tmdbclient.network.di

import com.anushka.tmdbclient.domain.repositories.artist.ArtistRepository
import com.anushka.tmdbclient.domain.repositories.movies.MovieRepository
import com.anushka.tmdbclient.domain.repositories.tvShows.TvShowRepository
import com.anushka.tmdbclient.domain.useCase.forArtists.GetArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forArtists.UpdateArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.GetTvShowsUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }


}