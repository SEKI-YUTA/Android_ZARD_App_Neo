package com.yuuta.zardAppNeo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Track(
    val trackName: String,
    val lyrics: String,
    val composition: String,
    val arrangement: String,
    val year: String,
) {
    override fun toString(): String {
        return "trackName: $trackName, lyrics: $lyrics, composition: $composition, arrangement: $arrangement"
    }
}
