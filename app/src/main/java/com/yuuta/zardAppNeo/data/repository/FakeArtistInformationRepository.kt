package com.yuuta.zardAppNeo.data.repository

import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import javax.inject.Inject

class FakeArtistInformationRepository
    @Inject
    constructor(
        private val dataSource: ArtistInformationSourceContract,
    ) :
    ArtistInformationRepository(
            dataSource,
        )
