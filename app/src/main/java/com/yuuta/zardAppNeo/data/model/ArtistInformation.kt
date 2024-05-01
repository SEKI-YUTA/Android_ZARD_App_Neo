package com.yuuta.zardAppNeo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ArtistInformation(
    val artistName: String,
    val debutYear: String,
    val debutMonth: String,
    val debutDate: String,
    val releasedDiscs: List<Disc>,
)
