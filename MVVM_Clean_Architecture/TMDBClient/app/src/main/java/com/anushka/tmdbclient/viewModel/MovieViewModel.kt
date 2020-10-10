package com.anushka.tmdbclient.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase
import com.anushka.tmdbclient.models.movie.Movie

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUsecase.execute()
        emit(movieList)
    }

}