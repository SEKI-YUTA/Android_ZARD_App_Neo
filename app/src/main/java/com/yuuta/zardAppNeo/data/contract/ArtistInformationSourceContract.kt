package com.yuuta.zardAppNeo.data.contract

import com.yuuta.common.model.Lce

interface ArtistInformationSourceContract {
    fun getArtistInformation(): com.yuuta.common.model.Lce<String>
}
