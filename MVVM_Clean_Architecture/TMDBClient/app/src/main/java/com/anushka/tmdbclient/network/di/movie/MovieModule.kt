package com.anushka.tmdbclient.network.di.movie

import com.anushka.tmdbclient.domain.useCase.forArtists.GetArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forArtists.UpdateArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase
import com.anushka.tmdbclient.viewModel.ArtistViewModelFactory
import com.anushka.tmdbclient.viewModel.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase, updateMoviesUseCase)
    }
}