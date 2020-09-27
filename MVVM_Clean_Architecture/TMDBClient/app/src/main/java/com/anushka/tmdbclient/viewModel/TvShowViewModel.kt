package com.anushka.tmdbclient.viewModel

import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.useCase.forTvShows.GetTvShowsUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.UpdateTvShowsUseCase
import com.anushka.tmdbclient.models.tvshow.TvShow

class TvShowViewModel(private val getTvShowsUseCase: GetTvShowsUseCase,
                      private val updateTvShowsUseCase: UpdateTvShowsUseCase) {

    fun getTvShows() = liveData<List<TvShow>> {
        val tvShowList = getTvShowsUseCase.execute()
        tvShowList?.let { emit(it) }
    }

    fun updateTvShows() = liveData<List<TvShow>> {
        val tvShowList = updateTvShowsUseCase.execute()
        tvShowList?.let { emit(it) }
    }
}