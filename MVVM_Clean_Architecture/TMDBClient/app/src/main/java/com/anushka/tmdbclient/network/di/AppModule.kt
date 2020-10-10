package com.anushka.tmdbclient.network.di

import android.content.Context
import com.anushka.tmdbclient.network.di.artist.ArtistSubComponent
import com.anushka.tmdbclient.network.di.movie.MovieSubComponent
import com.anushka.tmdbclient.network.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule (private val context: Context){

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}