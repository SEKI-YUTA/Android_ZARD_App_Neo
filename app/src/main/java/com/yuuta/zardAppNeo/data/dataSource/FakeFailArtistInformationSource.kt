package com.yuuta.zardAppNeo.data.dataSource

import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import java.io.FileNotFoundException
import javax.inject.Inject

class FakeFailArtistInformationSource
    @Inject
    constructor() :
    ArtistInformationSourceContract {
        override fun getArtistInformation(): Lce<String> {
            return Lce.Error(FileNotFoundException("can not find file"))
        }
    }
