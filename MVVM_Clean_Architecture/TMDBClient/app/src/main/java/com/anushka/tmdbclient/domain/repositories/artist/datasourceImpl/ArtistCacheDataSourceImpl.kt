package com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl

import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.models.movie.Movie
import com.anushka.tmdbclient.domain.repositories.movies.datasource.MovieCacheDataSource
import com.anushka.tmdbclient.models.artist.Artist

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}