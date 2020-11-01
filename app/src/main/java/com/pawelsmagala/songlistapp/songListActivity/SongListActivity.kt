package com.pawelsmagala.songlistapp.songListActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawelsmagala.songlistapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SongListActivity : AppCompatActivity() {

    private val viewModel: SongListViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val songAdapter = SongRecyclerAdapter()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel.songLiveData.observe(this, {
                songList -> songAdapter.setItemList(songList)
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