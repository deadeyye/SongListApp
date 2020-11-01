package com.pawelsmagala.infrastructure

import com.pawelsmagala.domain.song.Song
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*

object InfrastructureFactory
{
    fun moshi(jsonAdapter: Any?): Moshi {
        val builder = Moshi.Builder()
        jsonAdapter?.let { builder.add(it) }

        return builder
            .add(Date::class.java,  Rfc3339DateJsonAdapter())
            .addLast(KotlinJsonAdapterFactory())
            .build()

    }


    fun moshiSongAdapter(moshi: Moshi):  JsonAdapter<List<Song>>
    {
        val type = Types.newParameterizedType(List::class.java, Song::class.java)
        return moshi.adapter(type)
    }




}