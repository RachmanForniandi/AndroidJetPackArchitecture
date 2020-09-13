package com.anushka.tmdbclient.domain.repositories.artist.datasource

import com.anushka.tmdbclient.models.artist.ArtistList
import com.anushka.tmdbclient.models.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}