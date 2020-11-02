package com.pawelsmagala.songlistapp.songListActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.pawelsmagala.domain.song.SongSourceName
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

        binding.tabs.addOnTabSelectedListener(onTabSelectedListener)
        setupRecyclerView()

        viewModel.songLiveData.observe(this, {
                songList -> songAdapter.itemList = songList
        })

    }

    private fun setupRecyclerView() {
        binding.songListRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SongListActivity)
            adapter = songAdapter
        }
    }

    val onTabSelectedListener = object : OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0-> viewModel.getSongsFromAllSources()
                1 -> viewModel.getSongsFromSource(SongSourceName.LOCAL)
                2 -> viewModel.getSongsFromSource(SongSourceName.ITUNES)
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }


}