package com.anushka.tmdbclient.domain.repositories.datasource

import com.anushka.tmdbclient.models.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>

    suspend fun  saveMoviesToCache(movies:List<Movie>)
}