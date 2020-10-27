package com.pawelsmagala.infrastructure

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.IOException
import java.lang.Exception

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