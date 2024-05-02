package com.yuuta.zardAppNeo.data.dataSource

import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.model.Lce
import java.io.FileNotFoundException
import javax.inject.Inject

class FakeFailArtistInformationSource
    @Inject constructor()
    : ArtistInformationSourceContract {
    override fun getArtistInformation(): Lce<String> {
        return Lce.Error(FileNotFoundException("can not find file"))
    }
}
