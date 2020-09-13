package com.anushka.tmdbclient.domain.repositories.datasource

import com.anushka.tmdbclient.models.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb():List<Movie>
    suspend fun saveMoviesToDb(movies:List<Movie>)
    suspend fun clearAll()
}