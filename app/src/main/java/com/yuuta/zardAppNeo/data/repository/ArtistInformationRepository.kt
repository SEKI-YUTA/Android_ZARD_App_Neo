package com.yuuta.zardAppNeo.data.repository

import com.yuuta.common.model.ArtistInformation
import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.contract.ArtistInformationRepositoryContract
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.json.ZARDJson
import com.yuuta.zardAppNeo.di.annotation.ArtistInformationSourceAnnotation
import javax.inject.Inject

open class ArtistInformationRepository
    @Inject
    constructor(
        @ArtistInformationSourceAnnotation
        private val dataSource: ArtistInformationSourceContract,
    ) : ArtistInformationRepositoryContract {
        override fun getArtistInformation(): com.yuuta.common.model.Lce<com.yuuta.common.model.ArtistInformation> {
            val fileData = dataSource.getArtistInformation()
            if (fileData is com.yuuta.common.model.Lce.Error) {
                return com.yuuta.common.model.Lce.Error(fileData.getError()!!)
            }
            return com.yuuta.common.model.Lce.Content(ZARDJson.decodeFromString<com.yuuta.common.model.ArtistInformation>(fileData.getIfContent()!!))
        }
    }
