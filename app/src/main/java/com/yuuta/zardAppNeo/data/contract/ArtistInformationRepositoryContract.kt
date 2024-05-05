package com.yuuta.zardAppNeo.data.contract

import com.yuuta.common.model.ArtistInformation
import com.yuuta.common.model.Lce

interface ArtistInformationRepositoryContract {
    fun getArtistInformation(): com.yuuta.common.model.Lce<com.yuuta.common.model.ArtistInformation>
}
