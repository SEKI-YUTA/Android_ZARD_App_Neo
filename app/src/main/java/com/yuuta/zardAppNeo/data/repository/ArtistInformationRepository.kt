package com.yuuta.zardAppNeo.data.repository

import com.yuuta.common.model.ArtistInformation
import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.contract.ArtistInformationRepositoryContract
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.json.ZARDJson
import javax.inject.Inject

open class ArtistInformationRepository
    @Inject
    constructor(
        private val dataSource: ArtistInformationSourceContract,
    ) : ArtistInformationRepositoryContract {
        override fun getArtistInformation(): Lce<ArtistInformation> {
            val fileData = dataSource.getArtistInformation()
            if (fileData is Lce.Error) {
                return Lce.Error(fileData.getError()!!)
            }
            return Lce.Content(ZARDJson.decodeFromString<ArtistInformation>(fileData.getIfContent()!!))
        }
    }
