package com.anushka.tmdbclient.network.di.artist

import com.anushka.tmdbclient.domain.useCase.forArtists.GetArtistsUseCase
import com.anushka.tmdbclient.domain.useCase.forArtists.UpdateArtistsUseCase
import com.anushka.tmdbclient.viewModel.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistsUseCase: GetArtistsUseCase,
                                      updateArtistsUseCase: UpdateArtistsUseCase):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}