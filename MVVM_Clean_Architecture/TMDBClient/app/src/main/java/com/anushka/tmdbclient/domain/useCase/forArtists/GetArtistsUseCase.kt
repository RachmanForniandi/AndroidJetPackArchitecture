package com.anushka.tmdbclient.domain.useCase.forArtists

import com.anushka.tmdbclient.domain.repositories.artist.ArtistRepository
import com.anushka.tmdbclient.models.artist.Artist

class GetArtistsUseCase (private val artistRepository: ArtistRepository){
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}