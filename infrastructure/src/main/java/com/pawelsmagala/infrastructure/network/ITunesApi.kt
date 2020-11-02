package com.pawelsmagala.infrastructure.network

import com.pawelsmagala.infrastructure.song.itunesSong.ITunesSongResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ITunesApi {
    @GET("search")
    suspend fun searchSongs(@Query("term") searchTerm: String): ITunesSongResponse
}