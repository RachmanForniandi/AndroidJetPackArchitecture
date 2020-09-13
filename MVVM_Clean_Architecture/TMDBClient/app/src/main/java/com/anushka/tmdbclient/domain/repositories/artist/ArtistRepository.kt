package com.anushka.tmdbclient.domain.repositories.artist

import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}