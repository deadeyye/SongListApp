package com.pawelsmagala.infrastructure

import android.app.Application
import javax.inject.Inject

interface IAssetTextFileReader {
    fun readFileFromAsset(assetFilePath: String): String
}

open class AssetTextFileReader @Inject constructor( private val context: Application) : IAssetTextFileReader {
    override fun readFileFromAsset(assetFilePath: String): String {

        val stream = context.assets.open(assetFilePath)
        return stream.bufferedReader().use {it.readText()}




    }

}