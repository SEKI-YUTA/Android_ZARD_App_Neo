package com.yuuta.zardAppNeo.di.annotation

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ArtistInformationRepositoryAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeArtistInformationRepositoryAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeFailArtistInformationRepositoryAnnotation
