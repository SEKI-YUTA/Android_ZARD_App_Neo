package com.yuuta.zardAppNeo.ui

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

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = DISC_LIST_ROUTE,
    zardAppViewModel: ZARDAppViewModel,
) {
    val viewState = zardAppViewModel.viewState.collectAsState().value
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        discListScreen(
            navController = navController,
            navigateToDetail = navController::navigateToDiscDetail,
            discList = viewState.artistInformation.getIfContent()?.releasedDiscs
        )
        discDetailScreen(navController = navController)
        trackListRoute(navController = navController)
        settingRoute(navController = navController)
    }
}
