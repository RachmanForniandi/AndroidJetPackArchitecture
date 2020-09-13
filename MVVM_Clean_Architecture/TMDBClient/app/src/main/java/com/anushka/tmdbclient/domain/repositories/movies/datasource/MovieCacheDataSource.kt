package com.anushka.tmdbclient.domain.repositories.movies.datasource

import com.anushka.tmdbclient.models.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>

    suspend fun  saveMoviesToCache(movies:List<Movie>)
}