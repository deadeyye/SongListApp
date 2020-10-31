package com.pawelsmagala.songlistapp.SongListActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.songlistapp.databinding.SongListItemBinding

class SongAdapter():
    RecyclerView.Adapter<SongAdapter.ViewHolder>() {
    class ViewHolder(val binding: SongListItemBinding) : RecyclerView.ViewHolder(binding.root)

    val songList = ArrayList<Song>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SongListItemBinding.inflate(
            LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songList[position]
        holder.binding.txtFirstLine.text = song.songName
        holder.binding.txtSecondLine.text = song.getDescription()
    }

    override fun getItemCount() = songList.size

    fun setSongList(newSongList: List<Song>)
    {
        songList.clear()
        songList.addAll(newSongList)
        notifyDataSetChanged()
    }

}
