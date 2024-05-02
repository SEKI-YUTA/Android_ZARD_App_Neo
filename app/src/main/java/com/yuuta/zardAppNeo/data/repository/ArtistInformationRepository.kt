package com.yuuta.zardAppNeo.data.repository

import com.yuuta.zardAppNeo.data.contract.ArtistInformationRepositoryContract
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.json.ZARDJson
import com.yuuta.zardAppNeo.data.model.ArtistInformation
import com.yuuta.zardAppNeo.data.model.Lce
import javax.inject.Inject

class ArtistInformationRepository
    @Inject constructor(
        private val dataSource: ArtistInformationSourceContract
    ) : ArtistInformationRepositoryContract
{
    override fun getArtistInformation(): Lce<ArtistInformation> {
       val fileData = dataSource.getArtistInformation()
        if(fileData is Lce.Error) {
            return Lce.Error(fileData.getError()!!)
        }
        return Lce.Content(ZARDJson.decodeFromString<ArtistInformation>(fileData.getIfContent()!!))
    }

}
