package com.yuuta.zardAppNeo.di

import com.yuuta.zardAppNeo.data.contract.ArtistInformationDataSourceContract
import com.yuuta.zardAppNeo.data.dataSource.ArtistInformationDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindArtistInformationDataSource(dataSource: ArtistInformationDataSource): ArtistInformationDataSourceContract
}
