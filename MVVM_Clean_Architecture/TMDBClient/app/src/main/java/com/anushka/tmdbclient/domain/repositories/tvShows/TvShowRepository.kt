package com.anushka.tmdbclient.domain.repositories.tvShows

import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.models.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}