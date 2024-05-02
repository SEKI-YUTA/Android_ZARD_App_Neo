package com.yuuta.zardAppNeo.data.repository

import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.di.annotation.FakeArtistInformationSourceAnnotation
import javax.inject.Inject

class FakeFailArtistInformationRepository
    @Inject constructor(
        @FakeArtistInformationSourceAnnotation
        private val dataSource: ArtistInformationSourceContract
    )
    : ArtistInformationRepository(
        dataSource
    )
