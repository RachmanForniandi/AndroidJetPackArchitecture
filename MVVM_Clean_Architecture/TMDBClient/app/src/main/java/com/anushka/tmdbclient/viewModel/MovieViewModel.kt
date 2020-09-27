package com.anushka.tmdbclient.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase
import com.anushka.tmdbclient.models.movie.Movie

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase,private val updateMoviesUseCase: UpdateMoviesUseCase)
    : ViewModel() {


    fun getMovies() = liveData<List<Movie>> {
        val movieList = getMoviesUseCase.execute()
        movieList?.let { emit(it) }
    }

    fun updateMovies() = liveData<List<Movie>> {
        val movieList = updateMoviesUseCase.execute()
        movieList?.let { emit(it) }
    }


}