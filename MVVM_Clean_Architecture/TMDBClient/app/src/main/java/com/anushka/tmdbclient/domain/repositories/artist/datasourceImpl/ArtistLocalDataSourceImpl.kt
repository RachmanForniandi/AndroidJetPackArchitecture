package com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl

import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.local.ArtistDao
import com.anushka.tmdbclient.models.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDb(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDb(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch{
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtists()
        }
    }
}