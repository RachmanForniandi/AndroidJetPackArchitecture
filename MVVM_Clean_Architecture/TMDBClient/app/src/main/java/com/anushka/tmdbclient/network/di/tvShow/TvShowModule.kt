package com.anushka.tmdbclient.network.di.tvShow

import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.GetTvShowsUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.UpdateTvShowsUseCase
import com.anushka.tmdbclient.network.di.movie.MovieScope
import com.anushka.tmdbclient.viewModel.MovieViewModelFactory
import com.anushka.tmdbclient.viewModel.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowsUseCase: GetTvShowsUseCase,
                                     updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}