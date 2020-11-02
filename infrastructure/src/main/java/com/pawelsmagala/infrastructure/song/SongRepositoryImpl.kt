package com.pawelsmagala.infrastructure.song

import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.domain.song.SongRepository
import com.pawelsmagala.domain.song.SongSourceName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(val dataSources: Set<SongDataSource>): SongRepository {
    override fun getAllSongs(): Flow<List<Song>> {
        val flowList = dataSources.map { it.getSongList() }
        return combine(flowList) { listOfLists -> listOfLists.flatMap { it } }
    }

    override fun getSongsFromSource(sourceName: SongSourceName): Flow<List<Song>> {
        val filteredFlowList =
            dataSources.filter { it.getSourceName() == sourceName}.
            map { it.getSongList() }


        return combine(filteredFlowList) { listOfLists -> listOfLists.flatMap { it } }

    }
}