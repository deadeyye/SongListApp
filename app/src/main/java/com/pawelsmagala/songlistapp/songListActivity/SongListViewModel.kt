package com.pawelsmagala.songlistapp.songListActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pawelsmagala.domain.song.SongRepository
import com.pawelsmagala.domain.song.SongSourceName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class SongListViewModel @ViewModelInject constructor(
    songRepository: SongRepository,
    @Assisted private val savedStateHandle: SavedStateHandle


): ViewModel() {

    @ExperimentalCoroutinesApi
    private val songSourceFilter = MutableStateFlow<SongSourceName?>(null)
    val songLiveData =  songSourceFilter
        .flatMapLatest { songSourceFilter ->
            if (songSourceFilter == null)
                songRepository.getAllSongs()
            else
                songRepository.getSongsFromSource(songSourceFilter)
        }.asLiveData()

    fun getSongsFromAllSources()
    {
        songSourceFilter.value = null
    }

    fun getSongsFromSource(sourceName: SongSourceName)
    {
        songSourceFilter.value = sourceName
    }
}