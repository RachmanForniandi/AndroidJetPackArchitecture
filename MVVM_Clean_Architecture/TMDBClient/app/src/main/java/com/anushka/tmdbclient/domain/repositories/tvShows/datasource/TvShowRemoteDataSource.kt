package com.anushka.tmdbclient.domain.repositories.tvShows.datasource

import com.anushka.tmdbclient.models.artist.ArtistList
import com.anushka.tmdbclient.models.movie.MovieList
import com.anushka.tmdbclient.models.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}