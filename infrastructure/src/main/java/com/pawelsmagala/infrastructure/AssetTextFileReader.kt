package com.pawelsmagala.infrastructure

import android.app.Application
import android.content.Context
import java.io.IOException
import javax.inject.Inject

interface IAssetTextFileReader {
    fun readFileFromAsset(assetFilePath: String): String
}

open class AssetTextFileReader @Inject constructor( private val context: Application) : IAssetTextFileReader {
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