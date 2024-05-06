package com.yuuta.zardAppNeo.data.contract

import com.yuuta.common.model.ArtistInformation
import com.yuuta.common.model.Lce

interface ArtistInformationRepositoryContract {
    fun getArtistInformation(): Lce<ArtistInformation>
}
