package com.pawelsmagala.infrastructure.song.localFileSong

import com.squareup.moshi.Json

class LocalFileSongModel
    (
    @Json(name = "Song Clean")   var SongClean: String,
    @Json(name = "ARTIST CLEAN") var ArtistClean: String,
    @Json(name = "Release Year") var ReleaseYear: String
)