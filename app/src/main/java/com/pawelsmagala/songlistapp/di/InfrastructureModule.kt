package com.pawelsmagala.songlistapp.di

import android.app.Application
import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.infrastructure.AssetTextFileReader
import com.pawelsmagala.infrastructure.IAssetTextFileReader
import com.pawelsmagala.infrastructure.InfrastructureConfig
import com.pawelsmagala.infrastructure.InfrastructureFactory
import com.pawelsmagala.infrastructure.network.ITunesApi
import com.pawelsmagala.infrastructure.song.itunesSong.ITunesSongAdapter
import com.pawelsmagala.infrastructure.song.localFileSong.LocalFileSongAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object InfrastructureModule {
    @Provides
     fun provideAssetTextFileReader(context: Application): IAssetTextFileReader= AssetTextFileReader(context)

    @Provides
    @LocalJsonFormat
    fun provideMoshiWithLocalJsonFormat(): Moshi = InfrastructureFactory.moshi(LocalFileSongAdapter())

    @Provides
    @ITunesJsonFormat
    fun provideMoshiWithITunesJsonFormat(): Moshi = InfrastructureFactory.moshi(ITunesSongAdapter())



    @Provides
    fun provideLocalSongJsonAdapter(@LocalJsonFormat moshi: Moshi): JsonAdapter<List<Song>> =
        InfrastructureFactory.moshiSongAdapter(moshi)


    @Provides
    fun retrofit(@ITunesJsonFormat moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(InfrastructureConfig.iTunesApiUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    fun iTunesApiService(retrofit: Retrofit): ITunesApi = retrofit.create(ITunesApi::class.java)



}

