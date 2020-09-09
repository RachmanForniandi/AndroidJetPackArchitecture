package com.anushka.tmdbclient.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anushka.tmdbclient.models.artist.Artist
import com.anushka.tmdbclient.models.movie.Movie

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists:List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtists()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtists(artists:List<Artist>)

}