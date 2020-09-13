package com.anushka.tmdbclient.domain.repositories.datasourceImpl

import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.domain.repositories.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}