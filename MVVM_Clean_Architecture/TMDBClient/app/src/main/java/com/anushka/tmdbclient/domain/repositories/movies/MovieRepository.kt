package com.anushka.tmdbclient.domain.repositories.movies

import com.anushka.tmdbclient.models.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}