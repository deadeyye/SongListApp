package com.pawelsmagala.infrastructure.song.localFileSong

import com.pawelsmagala.domain.song.Song
import com.squareup.moshi.FromJson

class LocalFileSongAdapter() {
    @FromJson fun songFromLocalJson(localFileSongModel: LocalFileSongModel)=
        Song(localFileSongModel.SongClean, localFileSongModel.ArtistClean, localFileSongModel.ReleaseYear)

}