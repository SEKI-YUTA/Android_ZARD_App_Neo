package com.yuuta.zardAppNeo.di

import com.yuuta.zardAppNeo.data.contract.ArtistInformationRepositoryContract
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.dataSource.ArtistInformationSource
import com.yuuta.zardAppNeo.data.repository.ArtistInformationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindArtistInformationDataSource(dataSource: ArtistInformationSource): ArtistInformationSourceContract

    @Binds
    abstract fun bindArtistInformationRepository(repository: ArtistInformationRepository): ArtistInformationRepositoryContract
}
