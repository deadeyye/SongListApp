package com.pawelsmagala.domain.song

data class Song (
        val songName: String,
        val artist: String,
        val year: String
        )

{
        fun getDescription() = "$artist ($year)"
}