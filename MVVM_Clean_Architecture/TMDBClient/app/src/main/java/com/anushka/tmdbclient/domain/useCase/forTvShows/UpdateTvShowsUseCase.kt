package com.anushka.tmdbclient.domain.useCase.forTvShows

import com.anushka.tmdbclient.domain.repositories.TvShowRepository
import com.anushka.tmdbclient.models.tvshow.TvShow

class UpdateTvShowsUseCase (private val tvShowRepository: TvShowRepository){
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}