package com.yuuta.zardAppNeo.ui

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yuuta.common.model.NavigationDestination
import com.yuuta.discdetail.discDetailScreen
import com.yuuta.disclist.discListScreen
import com.yuuta.navigation.navigateToDiscDetail
import com.yuuta.setting.settingRoute
import com.yuuta.tracklist.trackListRoute
import com.yuuta.zardAppNeo.ui.viewmodel.ZARDAppViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: NavigationDestination = NavigationDestination.DiscList,
    zardAppViewModel: ZARDAppViewModel,
    openWebUrl: (String) -> Unit,
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
                openWebUrl = openWebUrl,
                setTappedDiscJacket = zardAppViewModel::setTappedDiscJacket,
                sharedTransitionScope = this@SharedTransitionLayout,
            )
            discDetailScreen(
                navController = navController,
                discList = viewState.artistInformation.getIfContent()?.releasedDiscs,
                openWebUrl = openWebUrl,
                getTappedDiscJacket = zardAppViewModel::getTappedDiscJacket,
                sharedTransitionScope = this@SharedTransitionLayout,
            )
            trackListRoute(
                navController = navController,
                allTrackList =
                    viewState.artistInformation.getIfContent()?.releasedDiscs
                        ?.map { it.trackList }?.flatten()?.toSet()?.toList(),
                openWebUrl = openWebUrl,
            )
            settingRoute(
                navController = navController,
                appSetting = viewState.appSetting.getIfContent(),
                updateAppSetting = zardAppViewModel::updateAppSetting,
                openWebUrl = openWebUrl,
            )
        }
    }
}
