package com.yuuta.common.model

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationDestination {
    @Serializable
    data object DiscList : NavigationDestination()
    @Serializable
    data class DiscDetail(val discId: String) : NavigationDestination()
    @Serializable
    data object TrackList : NavigationDestination()
    @Serializable
    data object Setting : NavigationDestination()
}
