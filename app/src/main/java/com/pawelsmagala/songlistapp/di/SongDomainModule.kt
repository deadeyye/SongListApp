package com.pawelsmagala.songlistapp.di

import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.domain.song.SongRepository
import com.pawelsmagala.infrastructure.IAssetTextFileReader
import com.pawelsmagala.infrastructure.InfrastructureConfig
import com.pawelsmagala.infrastructure.network.ITunesApi
import com.pawelsmagala.infrastructure.song.SongRepositoryImpl
import com.pawelsmagala.infrastructure.song.itunesSong.ITunesSongDataSource
import com.pawelsmagala.infrastructure.song.localFileSong.LocalFileSongDataSource
import com.squareup.moshi.JsonAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityComponent::class)
object SongDomainModule {

    @Provides
    @IntoSet
    fun localSongDataSource(  assetTextFileReader: IAssetTextFileReader, songJsonAdapter: JsonAdapter<List<Song>>) : SongDataSource
    {
        return LocalFileSongDataSource(assetTextFileReader, songJsonAdapter, InfrastructureConfig.jsonFileName)
    }

    @Provides
    @IntoSet
    fun iTunesSongDataSource(iTunesApi: ITunesApi): SongDataSource
    {
        return ITunesSongDataSource(iTunesApi, InfrastructureConfig.iTunesSongQuery)
    }


    @Provides
    fun songRepository(songSources: Set<@JvmSuppressWildcards SongDataSource>): SongRepository =
        SongRepositoryImpl(songSources)





}