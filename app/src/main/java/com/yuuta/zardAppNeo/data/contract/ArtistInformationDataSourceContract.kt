package com.yuuta.zardAppNeo.data.contract

import com.yuuta.zardAppNeo.data.model.Lce

interface ArtistInformationDataSourceContract {
    fun getArtistInformation(): Lce<String>
}
