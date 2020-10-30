package com.pawelsmagala.songlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.songlistapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private lateinit var viewAdapter: RecyclerView.Adapter<*>


    @Inject
    lateinit var songDataSource: SongDataSource
    var songList: ArrayList<Song> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        songDataSource.getSongList().asLiveData().observe(this,
                { songListNew ->
                    songList.clear()
                    songList.addAll(songListNew)
                    viewAdapter.notifyDataSetChanged()
                })

    }

    private fun setupRecyclerView() {
        viewAdapter = SongAdapter(songList)

        binding.songListRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter
        }
    }
}