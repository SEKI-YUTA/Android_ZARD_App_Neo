package com.yuuta.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Disc(
    val id: Int = 0,
    val name: String,
    val releaseYear: String,
    val releaseMonth: String,
    val releaseDate: String,
    val indexStr: String,
    val discType: String,
    val is8cm: Boolean,
    @SerialName("image")
    val imageName: String,
    val trackList: List<Track>,
    val officialPageURL: String,
)
