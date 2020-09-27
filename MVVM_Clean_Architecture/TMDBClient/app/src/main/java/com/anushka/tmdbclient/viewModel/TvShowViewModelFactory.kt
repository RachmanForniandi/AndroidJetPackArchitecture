package com.anushka.tmdbclient.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.GetTvShowsUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.UpdateTvShowsUseCase

class TvShowViewModelFactory(private val getTvShowsUseCase: GetTvShowsUseCase
                             , private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
    }
}