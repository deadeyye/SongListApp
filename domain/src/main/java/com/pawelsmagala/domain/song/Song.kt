package com.pawelsmagala.domain.song

data class Song (
        val songName: String,
        val artist: String,
        val year: String
        )

{

        fun getYearDescription() = year.ifBlank { "year unknown" }//this should be translatable string, but for purpose of this task I'll leave it as is
        fun getDescription() = "$artist (${getYearDescription()})"
}