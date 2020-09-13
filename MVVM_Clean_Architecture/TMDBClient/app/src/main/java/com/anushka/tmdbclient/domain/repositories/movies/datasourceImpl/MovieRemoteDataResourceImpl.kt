package com.anushka.tmdbclient.domain.repositories.movies.datasourceImpl

import com.anushka.tmdbclient.models.movie.MovieList
import com.anushka.tmdbclient.network.APIService
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataResourceImpl(private val tmdBService:APIService, private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdBService.getPopularMovies(apiKey)
}