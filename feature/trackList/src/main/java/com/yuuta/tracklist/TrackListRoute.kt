package com.yuuta.tracklist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.common.model.Track
import com.yuuta.navigation.TRACK_LIST_ROUTE

fun NavGraphBuilder.trackListRoute(
    navController: NavController,
    allTrackList: List<Track>?,
) {
    composable(TRACK_LIST_ROUTE) {
        TrackListScreen(
            navController = navController,
            allTrackList = allTrackList,
        )
    }
}
