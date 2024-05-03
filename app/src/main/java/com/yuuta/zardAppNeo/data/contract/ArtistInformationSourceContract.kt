package com.yuuta.zardAppNeo.data.contract

import com.yuuta.zardAppNeo.data.model.Lce

interface ArtistInformationSourceContract {
    fun getArtistInformation(): Lce<String>
}
