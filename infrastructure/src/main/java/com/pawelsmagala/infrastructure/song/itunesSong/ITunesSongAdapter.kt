package com.pawelsmagala.infrastructure.song.itunesSong

import com.pawelsmagala.domain.song.Song
import com.squareup.moshi.FromJson
import java.util.*

class ITunesSongAdapter {
    @FromJson
    fun songFromItunesJson(iTunesSongModel: ITunesSongModel) : Song {
        /*
        I used old Java api to maintain compatibility for Android below Oreo, and I didn't wanted
        to insert JodaTime dependency for single extraction of year
         */

        val calendar = Calendar.getInstance()
        calendar.time = iTunesSongModel.releaseDate
        val releaseYear = calendar.get(Calendar.YEAR).toString()

        return Song(iTunesSongModel.trackName, iTunesSongModel.artistName, releaseYear)
    }

}