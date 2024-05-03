package com.yuuta.tracklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val TRACK_LIST_ROUTE = "ZARDAppNeo/trackList"

fun NavGraphBuilder.trackListRoute() {
    composable(TRACK_LIST_ROUTE) {
        TrackListScreen()
    }
}
