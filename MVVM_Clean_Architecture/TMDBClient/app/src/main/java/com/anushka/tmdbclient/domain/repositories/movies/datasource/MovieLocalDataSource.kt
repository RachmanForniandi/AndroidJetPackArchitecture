package com.anushka.tmdbclient.domain.repositories.movies.datasource

import com.anushka.tmdbclient.models.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb():List<Movie>
    suspend fun saveMoviesToDb(movies:List<Movie>)
    suspend fun clearAll()
}