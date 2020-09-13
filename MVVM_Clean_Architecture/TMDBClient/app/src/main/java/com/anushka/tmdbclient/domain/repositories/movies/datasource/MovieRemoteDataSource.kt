package com.anushka.tmdbclient.domain.repositories.movies.datasource

import com.anushka.tmdbclient.models.artist.ArtistList
import com.anushka.tmdbclient.models.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}