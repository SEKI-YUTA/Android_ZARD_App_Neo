package com.yuuta.zardAppNeo.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yuuta.discdetail.discDetailScreen
import com.yuuta.disclist.discListScreen
import com.yuuta.navigation.DISC_LIST_ROUTE
import com.yuuta.navigation.navigateToDiscDetail
import com.yuuta.setting.settingRoute
import com.yuuta.tracklist.trackListRoute
import com.yuuta.zardAppNeo.ui.viewmodel.ZARDAppViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = DISC_LIST_ROUTE,
    zardAppViewModel: ZARDAppViewModel,
) {
    val viewState = zardAppViewModel.viewState.collectAsState().value
    val navController = rememberNavController()
    SharedTransitionLayout {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination,
        ) {
            discListScreen(
                navController = navController,
                navigateToDetail = navController::navigateToDiscDetail,
                discList = viewState.artistInformation.getIfContent()?.releasedDiscs,
                sharedTransitionScope = this@SharedTransitionLayout,
            )
            discDetailScreen(
                navController = navController,
                discList = viewState.artistInformation.getIfContent()?.releasedDiscs,
                sharedTransitionScope = this@SharedTransitionLayout,
            )
            trackListRoute(
                navController = navController,
                allTrackList = viewState.artistInformation.getIfContent()?.releasedDiscs?.map { it.trackList }?.flatten()?.toSet()?.toList(),
            )
            settingRoute(navController = navController)
        }
    }
}
