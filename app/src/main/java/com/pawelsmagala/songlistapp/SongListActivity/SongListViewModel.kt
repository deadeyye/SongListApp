package com.pawelsmagala.songlistapp.SongListActivity

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.pawelsmagala.domain.song.SongDataSource

class SongListViewModel @ViewModelInject constructor(
    val songDataSource: SongDataSource,
    @Assisted private val savedStateHandle: SavedStateHandle


): ViewModel() {

    val songLiveData =  songDataSource.getSongList().asLiveData()

}