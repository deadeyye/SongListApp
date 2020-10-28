package com.pawelsmagala.songlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        viewAdapter = SongAdapter(
            listOf(
                Song("Caught Up in You", ".38 Special", "1982"),
                Song("Fantasy Girl", ".38 Special", "")
            )
        )

        binding.songListRecycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = viewAdapter
        }
    }
}