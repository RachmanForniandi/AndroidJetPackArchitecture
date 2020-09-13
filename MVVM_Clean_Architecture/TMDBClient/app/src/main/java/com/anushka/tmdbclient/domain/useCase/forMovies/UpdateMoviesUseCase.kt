package com.anushka.tmdbclient.domain.useCase.forMovies

import com.anushka.tmdbclient.domain.repositories.MovieRepository
import com.anushka.tmdbclient.models.movie.Movie

class UpdateMoviesUseCase (private val movieRepository: MovieRepository){
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}