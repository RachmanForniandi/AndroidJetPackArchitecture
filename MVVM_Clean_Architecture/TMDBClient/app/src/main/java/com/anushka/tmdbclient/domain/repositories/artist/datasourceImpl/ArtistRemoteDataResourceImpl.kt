package com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl

import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.network.APIService
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieRemoteDataSource
import com.anushka.tmdbclient.models.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataResourceImpl(private val tmdBService:APIService, private val apiKey:String):
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdBService.getPopularArtist(apiKey)
}