package com.pawelsmagala.songlistapp.di

import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.infrastructure.IAssetTextFileReader
import com.pawelsmagala.infrastructure.InfrastructureConfig
import com.pawelsmagala.infrastructure.song.localFileSong.LocalFileSongDataSource
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object DomainModule {

    @Provides
    fun songDataSource(  assetTextFileReader: IAssetTextFileReader,
                                 moshi: Moshi
    ) : SongDataSource
    {
        return LocalFileSongDataSource(assetTextFileReader, moshi, InfrastructureConfig.jsonFileName)
    }

}