package com.pawelsmagala.songlistapp.SongListActivity

import android.opengl.GLES32
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pawelsmagala.domain.song.Song
import com.pawelsmagala.domain.song.SongDataSource
import com.pawelsmagala.songlistapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SongListActivity : AppCompatActivity() {

    private val viewModel: SongListViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val songAdapter = SongAdapter()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel.songLiveData.observe(this, {
                        songListNew -> songAdapter.setSongList(songListNew)
                })

    }

    private fun setupRecyclerView() {
        binding.songListRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SongListActivity)
            adapter = songAdapter
        }
    }
}