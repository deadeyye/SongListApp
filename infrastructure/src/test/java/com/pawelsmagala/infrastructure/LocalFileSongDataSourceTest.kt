package com.pawelsmagala.infrastructure


import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.infrastructure.song.localFileSong.LocalFileSongDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.anyString
import java.io.IOException


class LocalFileSongDataSourceTest {

    private val properJsonFile = "songs-list.json"
    private val brokenJsonFile = "broken-songs-list.json"

    private val fileReaderMock: AssetTextFileReader = mock()


    private val moshi = InfrastuctureFactory.moshi()

    private val songDataSource = LocalFileSongDataSource(fileReaderMock, moshi, InfrastructureConfig.jsonFileName)

    @ExperimentalCoroutinesApi
    @Test
    fun `loaded file should return proper song data`() = runBlocking<Unit> {

        //given
        val json = loadFileFromTestResource(properJsonFile)
        whenever(fileReaderMock.readFileFromAsset(anyString()))
            .thenReturn(json)

        val expectedSongListStart = listOf(
            Song("Caught Up in You",".38 Special", "1982"),
            Song("Fantasy Girl",".38 Special", "")
        )

        //when
        val actualSongList = songDataSource.getSongList().single()

        //then
        assertEquals(expectedSongListStart[0], actualSongList[0])
        assertEquals(expectedSongListStart[1], actualSongList[1])
        assertEquals(2229, actualSongList.size)

    }

    @ExperimentalCoroutinesApi
    @Test(expected = IOException::class)
    fun `broken file should return IOException`() = runBlocking<Unit> {

        //given
        val json = loadFileFromTestResource(brokenJsonFile)
        whenever(fileReaderMock.readFileFromAsset(anyString()))
            .thenReturn(json)

        //when
        songDataSource.getSongList().single()

        //then expected exception

    }


    private fun loadFileFromTestResource(fileName: String) = javaClass.classLoader!!.getResource(fileName).readText()





}