package com.anushka.tmdbclient.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anushka.tmdbclient.domain.useCase.forArtists.GetArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forArtists.UpdateArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.GetMoviesUseCase
import com.anushka.tmdbclient.domain.useCase.forMovies.UpdateMoviesUseCase

class ArtistViewModelFactory (private val getArtistsUseCase: GetArtistsUseCase
                              , private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase,updateArtistsUseCase) as T
    }
}