package com.yuuta.zardAppNeo.data.dataSource

import android.content.Context
import com.yuuta.zardAppNeo.data.contract.ArtistInformationDataSourceContract
import com.yuuta.zardAppNeo.data.model.Lce
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject

class ArtistInformationDataSource
    @Inject
    constructor(
        @ApplicationContext
        private val context: Context,
    ) : ArtistInformationDataSourceContract {
        override fun getArtistInformation(): Lce<String> {
            val builder = StringBuilder()
            try {
                val fileInputStream = context.assets.open("info.json")
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = inputStreamReader.buffered()
                var text: String?
                while (true) {
                    text = bufferedReader.readLine()
                    if (text == null) break
                    builder.append("$text\n")
                }
            } catch (e: Exception) {
                return Lce.Error(e)
            }
            return Lce.Content(builder.toString())
        }
    }
