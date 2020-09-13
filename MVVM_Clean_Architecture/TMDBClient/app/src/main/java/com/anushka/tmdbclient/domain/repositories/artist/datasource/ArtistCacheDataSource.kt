package com.anushka.tmdbclient.domain.repositories.artist.datasource

import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>

    suspend fun saveArtistToCache(artists:List<Artist>)
}