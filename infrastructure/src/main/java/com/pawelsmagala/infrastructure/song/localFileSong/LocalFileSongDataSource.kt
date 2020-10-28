package com.pawelsmagala.infrastructure.song.localFileSong

import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.infrastructure.IAssetTextFileReader
import com.pawelsmagala.infrastructure.InfrastuctureFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LocalFileSongDataSource (
    private val assetTextFileReader: IAssetTextFileReader,
    private val moshi: Moshi,
    private val fileName: String
) : SongDataSource {

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun getSongList() = flow {


        val json = assetTextFileReader.readFileFromAsset(fileName)
        val jsonAdapter = InfrastuctureFactory.moshiSongAdapter()
        val songList: List<Song> = jsonAdapter.fromJson(json) ?: emptyList()
        emit(songList)
    }.flowOn(Dispatchers.IO)




    override fun getSourceName() = "local"


}