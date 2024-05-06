package com.yuuta.tracklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.navigation.TRACK_LIST_ROUTE

fun NavGraphBuilder.trackListRoute() {
    composable(TRACK_LIST_ROUTE) {
        TrackListScreen()
    }
}
