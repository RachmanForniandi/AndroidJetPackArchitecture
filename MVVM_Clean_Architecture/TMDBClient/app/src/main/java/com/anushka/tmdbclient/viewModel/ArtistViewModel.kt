package com.anushka.tmdbclient.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.tmdbclient.domain.useCase.forArtists.GetArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forArtists.UpdateArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.GetTvShowsUseCase
import com.anushka.tmdbclient.domain.useCase.forTvShows.UpdateTvShowsUseCase
import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie

class ArtistViewModel (private val getArtistsUseCase: GetArtistsUseCase,
                       private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {
    fun getArtists() = liveData<List<Artist>> {
        val artistList = getArtistsUseCase.execute()
        artistList?.let { emit(it) }
    }

    fun updateArtists() = liveData<List<Artist>> {
        val artistList = updateArtistsUseCase.execute()
        artistList?.let { emit(it) }
    }

}