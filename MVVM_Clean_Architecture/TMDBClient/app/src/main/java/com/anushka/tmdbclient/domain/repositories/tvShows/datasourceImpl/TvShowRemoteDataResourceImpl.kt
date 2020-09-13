package com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl

import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.network.APIService
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.domain.repositories.tvShows.datasource.TvShowRemoteDataSource
import com.anushka.tmdbclient.models.artist.ArtistList
import com.anushka.tmdbclient.models.tvshow.TvShowList
import retrofit2.Response

class TvShowRemoteDataResourceImpl(private val tmdBService:APIService, private val apiKey:String):
    TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdBService.getPopularTvShows(apiKey)
}