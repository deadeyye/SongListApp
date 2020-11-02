package com.pawelsmagala.infrastructure.song.itunesSong

import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.domain.song.SongSourceName
import com.pawelsmagala.infrastructure.network.ITunesApi
import kotlinx.coroutines.flow.flow

class ITunesSongDataSource(val iTunesApi: ITunesApi, val searchQuery: String): SongDataSource{
    override fun getSongList() = flow {
        emit(iTunesApi.searchSongs(searchQuery).results)
    }

    override fun getSourceName() = SongSourceName.ITUNES
}