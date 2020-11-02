package com.pawelsmagala.domain.song

import kotlinx.coroutines.flow.Flow

interface SongDataSource {
    fun getSongList(): Flow<List<Song>>
    fun getSourceName(): SongSourceName
}