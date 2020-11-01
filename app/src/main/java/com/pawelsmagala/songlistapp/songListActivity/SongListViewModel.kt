package com.pawelsmagala.songlistapp.songListActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.domain.song.SongRepository

class SongListViewModel @ViewModelInject constructor(
    val songRepository: SongRepository,
    @Assisted private val savedStateHandle: SavedStateHandle


): ViewModel() {

    val songLiveData =  songRepository.getAllSongs().asLiveData()

}