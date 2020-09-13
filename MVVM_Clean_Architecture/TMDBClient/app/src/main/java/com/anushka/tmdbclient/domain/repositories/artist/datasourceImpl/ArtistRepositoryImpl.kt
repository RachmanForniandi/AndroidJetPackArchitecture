package com.anushka.tmdbclient.domain.repositories.artist.datasourceImpl

import android.util.Log
import com.anushka.tmdbclient.domain.repositories.artist.ArtistRepository
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistCacheDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistLocalDataSource
import com.anushka.tmdbclient.domain.repositories.artist.datasource.ArtistRemoteDataSource
import com.anushka.tmdbclient.domain.repositories.movies.MovieRepository
import com.anushka.tmdbclient.models.artist.Artist

class ArtistRepositoryImpl(private val artistRemoteDataSource: ArtistRemoteDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {


    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfMovies = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDb(newListOfMovies)
        artistCacheDataSource.saveArtistToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body != null){
                artistList = body.results
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>? {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }

     suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDb()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDb(artistList)
        }
        return artistList
    }


}