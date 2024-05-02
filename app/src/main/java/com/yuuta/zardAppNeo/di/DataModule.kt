package com.yuuta.zardAppNeo.di

import com.yuuta.zardAppNeo.data.contract.ArtistInformationRepositoryContract
import com.yuuta.zardAppNeo.data.contract.ArtistInformationSourceContract
import com.yuuta.zardAppNeo.data.dataSource.ArtistInformationSource
import com.yuuta.zardAppNeo.data.dataSource.FakeArtistInformationSource
import com.yuuta.zardAppNeo.data.dataSource.FakeFailArtistInformationSource
import com.yuuta.zardAppNeo.data.repository.ArtistInformationRepository
import com.yuuta.zardAppNeo.data.repository.FakeArtistInformationRepository
import com.yuuta.zardAppNeo.data.repository.FakeFailArtistInformationRepository
import com.yuuta.zardAppNeo.di.annotation.ArtistInformationRepositoryAnnotation
import com.yuuta.zardAppNeo.di.annotation.ArtistInformationSourceAnnotation
import com.yuuta.zardAppNeo.di.annotation.FakeArtistInformationRepositoryAnnotation
import com.yuuta.zardAppNeo.di.annotation.FakeArtistInformationSourceAnnotation
import com.yuuta.zardAppNeo.di.annotation.FakeFailArtistInformationRepositoryAnnotation
import com.yuuta.zardAppNeo.di.annotation.FakeFailArtistInformationSourceAnnotation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @ArtistInformationSourceAnnotation
    @Binds
    abstract fun bindArtistInformationDataSource(dataSource: ArtistInformationSource): ArtistInformationSourceContract

    @FakeArtistInformationSourceAnnotation
    @Binds
    abstract fun bindFakeArtistInformationDataSource(dataSource: FakeArtistInformationSource): ArtistInformationSourceContract

    @FakeFailArtistInformationSourceAnnotation
    @Binds
    abstract fun bindFakeFailArtistInformationDataSource(dataSource: FakeFailArtistInformationSource): ArtistInformationSourceContract

    @ArtistInformationRepositoryAnnotation
    @Binds
    abstract fun bindArtistInformationRepository(repository: ArtistInformationRepository): ArtistInformationRepositoryContract

    @FakeArtistInformationRepositoryAnnotation
    @Binds
    abstract fun bindFakeArtistInformationRepository(repository: FakeArtistInformationRepository): ArtistInformationRepositoryContract

    @FakeFailArtistInformationRepositoryAnnotation
    @Binds
    abstract fun bindFakeFailArtistInformationRepository(repository: FakeFailArtistInformationRepository): ArtistInformationRepositoryContract
}
