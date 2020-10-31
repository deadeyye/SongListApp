package com.pawelsmagala.songlistapp.songListActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.songlistapp.GenericViewBindingAdapter
import com.pawelsmagala.songlistapp.databinding.SongListItemBinding

class SongAdapter : GenericViewBindingAdapter<SongListItemBinding, Song>() {
    override fun generateViewWithBinding(parent: ViewGroup): SongListItemBinding {
        return SongListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
    }

    override fun fillViewWithData(bindingView: SongListItemBinding, item: Song) {
        bindingView.txtFirstLine.text = item.songName
        bindingView.txtSecondLine.text = item.getDescription()
    }


}
