package com.yuuta.tracklist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.common.model.NavigationDestination
import com.yuuta.common.model.Track

fun NavGraphBuilder.trackListRoute(
    navController: NavController,
    allTrackList: List<Track>?,
    openWebUrl: (String) -> Unit,
) {
    composable<NavigationDestination.TrackList> {
        TrackListScreen(
            navController = navController,
            allTrackList = allTrackList,
            openWebUrl = openWebUrl,
        )
    }
}
