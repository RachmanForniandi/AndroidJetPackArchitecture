package com.anushka.tmdbclient.domain.repositories.tvShows.datasource

import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.models.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>

    suspend fun saveTvShowToCache(tvShows:List<TvShow>)
}