package com.yuuta.zardAppNeo.data.contract

import com.yuuta.zardAppNeo.data.model.ArtistInformation
import com.yuuta.zardAppNeo.data.model.Lce

interface ArtistInformationRepositoryContract {
    fun getArtistInformation(): Lce<ArtistInformation>
}
