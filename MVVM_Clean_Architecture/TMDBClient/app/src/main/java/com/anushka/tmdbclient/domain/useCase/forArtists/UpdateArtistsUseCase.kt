package com.anushka.tmdbclient.domain.useCase.forArtists

import com.anushka.tmdbclient.domain.repositories.ArtistRepository
import com.anushka.tmdbclient.models.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}