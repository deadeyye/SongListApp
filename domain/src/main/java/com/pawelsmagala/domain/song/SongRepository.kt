package com.pawelsmagala.domain.song

import kotlinx.coroutines.flow.Flow

interface SongRepository {
    fun getAllSongs(): Flow<List<Song>>
    fun getSongsFromSource(sourceName: SongSourceName): Flow<List<Song>>
}