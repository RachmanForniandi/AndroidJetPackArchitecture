package com.anushka.tmdbclient.domain.repositories.artist.datasource

import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDb():List<Artist>
    suspend fun saveArtistsToDb(artists:List<Artist>)
    suspend fun clearAll()
}