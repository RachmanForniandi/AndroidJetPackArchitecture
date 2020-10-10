package com.anushka.tmdbclient.models.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artists")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    /*@SerializedName("known_for")
    val knownFor: List<KnownFor>,*/
    @SerializedName("name")
    val name: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String,



    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("known_for_department")
    val knownForDepartment: String



)