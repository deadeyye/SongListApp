package com.pawelsmagala.infrastructure

import android.content.Context
import java.io.IOException

interface IAssetTextFileReader {
    fun readFileFromAsset(assetFilePath: String): String
}

open class AssetTextFileReader constructor(private val context: Context) : IAssetTextFileReader {
    override fun readFileFromAsset(assetFilePath: String): String {

        val stream = context.assets.open(assetFilePath)
        try {
            return stream.readBytes().toString()
        } catch (e: Exception) {
            throw IOException(e.message, e)
        } finally {
            stream.close()
        }



    }

}