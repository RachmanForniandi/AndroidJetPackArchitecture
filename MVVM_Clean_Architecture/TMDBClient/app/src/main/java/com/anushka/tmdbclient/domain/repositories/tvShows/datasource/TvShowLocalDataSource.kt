package com.anushka.tmdbclient.domain.repositories.tvShows.datasource

import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.models.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb():List<TvShow>
    suspend fun saveTvShowsToDb(tvShows:List<TvShow>)
    suspend fun clearAll()
}