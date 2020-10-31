package com.pawelsmagala.infrastructure

import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.infrastructure.song.localFileSong.LocalFileSongAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object InfrastuctureFactory
{
    fun moshi(): Moshi = Moshi.Builder().
                            add(LocalFileSongAdapter())
                            .addLast( KotlinJsonAdapterFactory())
                            .build()


    fun moshiSongAdapter():  JsonAdapter<List<Song>>
    {
        val type = Types.newParameterizedType(List::class.java, Song::class.java)
        return moshi().adapter(type)
    }



}