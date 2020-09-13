package com.anushka.tmdbclient.domain.useCase.forTvShows

import com.anushka.tmdbclient.domain.repositories.tvShows.TvShowRepository
import com.anushka.tmdbclient.models.tvshow.TvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}