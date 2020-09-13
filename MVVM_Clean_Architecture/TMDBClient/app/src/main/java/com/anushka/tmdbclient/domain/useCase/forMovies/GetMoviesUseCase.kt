package com.anushka.tmdbclient.domain.useCase.forMovies

import com.anushka.tmdbclient.domain.repositories.movies.MovieRepository
import com.anushka.tmdbclient.models.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}