package com.yuuta.zardAppNeo.data.dataSource

import android.content.Context
import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject

class ArtistInformationSource
    @Inject
    constructor(
        @ApplicationContext
        private val context: Context,
    ) : ArtistInformationSourceContract {
        override fun getArtistInformation(): com.yuuta.common.model.Lce<String> {
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
                return com.yuuta.common.model.Lce.Error(e)
            }
            return com.yuuta.common.model.Lce.Content(builder.toString())
        }
    }
