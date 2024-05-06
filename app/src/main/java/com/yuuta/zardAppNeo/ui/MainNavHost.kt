package com.yuuta.zardAppNeo.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yuuta.discdetail.discDetailScreen
import com.yuuta.discdetail.navigateToDiscDetail
import com.yuuta.disclist.DISC_LIST_ROUTE
import com.yuuta.disclist.discListScreen
import com.yuuta.setting.settingRoute
import com.yuuta.tracklist.trackListRoute

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = DISC_LIST_ROUTE,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        discListScreen(navigateToDetail = navController::navigateToDiscDetail)
        discDetailScreen()
        trackListRoute()
        settingRoute()
    }
}
