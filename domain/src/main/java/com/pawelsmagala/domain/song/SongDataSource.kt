package com.pawelsmagala.domain.song

import com.pawelsmagala.domain.song.Song
import kotlinx.coroutines.flow.Flow

interface SongDataSource {
    fun getSongList() : Flow<List<Song>>
}