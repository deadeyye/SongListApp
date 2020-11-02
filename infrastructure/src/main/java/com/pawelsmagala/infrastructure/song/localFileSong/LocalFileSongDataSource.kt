package com.pawelsmagala.infrastructure.song.localFileSong

import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.domain.song.SongSourceName
import com.pawelsmagala.infrastructure.utils.IAssetTextFileReader
import com.squareup.moshi.JsonAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LocalFileSongDataSource (
    private val assetTextFileReader: IAssetTextFileReader,
    private val jsonAdapter: JsonAdapter<List<Song>>,
    private val fileName: String
) : SongDataSource {

    @Suppress("BlockingMethodInNonBlockingContext")
    override fun getSongList() = flow {

        val json = assetTextFileReader.readFileFromAsset(fileName)
        val songList: List<Song> = jsonAdapter.fromJson(json) ?: emptyList()
        emit(songList)
    }.flowOn(Dispatchers.IO)




    override fun getSourceName() = SongSourceName.LOCAL


}