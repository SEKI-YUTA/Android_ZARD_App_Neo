package com.yuuta.zardAppNeo.di.annotation

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ArtistInformationSourceAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeArtistInformationSourceAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FakeFailArtistInformationSourceAnnotation
