package com.anushka.tmdbclient.domain.repositories.datasource

import com.anushka.tmdbclient.models.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}