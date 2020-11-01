package com.pawelsmagala.songlistapp.di

import android.app.Application
import com.pawelsmagala.infrastructure.AssetTextFileReader
import com.pawelsmagala.infrastructure.IAssetTextFileReader
import com.pawelsmagala.infrastructure.InfrastuctureFactory
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object InfrastructureModule {
    @Provides
     fun bindsAssetTextFileReader(context: Application): IAssetTextFileReader= AssetTextFileReader(context)

    @Provides
    fun returnMoshi(): Moshi = InfrastuctureFactory.moshi()


}

