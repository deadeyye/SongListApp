package com.pawelsmagala.domain.song

import kotlinx.coroutines.flow.Flow

interface SongDataSource {
    suspend fun getSongList(): Flow<List<Song>>
    fun getSourceName(): String
}