package com.pawelsmagala.songlistapp.di

import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.domain.song.SongRepository
import com.pawelsmagala.infrastructure.IAssetTextFileReader
import com.pawelsmagala.infrastructure.InfrastructureConfig
import com.pawelsmagala.infrastructure.song.SongRepositoryImpl
import com.pawelsmagala.infrastructure.song.localFileSong.LocalFileSongDataSource
import com.squareup.moshi.Moshi
import dagger.Binds
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
    fun localSongDataSource(  assetTextFileReader: IAssetTextFileReader, moshi: Moshi) : SongDataSource
    {
        return LocalFileSongDataSource(assetTextFileReader, moshi, InfrastructureConfig.jsonFileName)
    }


    @Provides
    fun songRepository(songSources: Set<@JvmSuppressWildcards SongDataSource>): SongRepository =
        SongRepositoryImpl(songSources)





}