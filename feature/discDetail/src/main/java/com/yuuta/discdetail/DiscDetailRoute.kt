package com.yuuta.discdetail

import android.graphics.Bitmap
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.yuuta.common.model.Disc
import com.yuuta.common.model.NavigationDestination

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.discDetailScreen(
    navController: NavController,
    discList: List<Disc>?,
    openWebUrl: (String) -> Unit,
    getTappedDiscJacket: () -> Bitmap,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable<NavigationDestination.DiscDetail> {
        val discDetailArgs: NavigationDestination.DiscDetail = it.toRoute()
        val targetDisc = discList?.find { it.id.toString() == discDetailArgs.discId }
        DiscDetailScreen(
            navController = navController,
            animatedVisibilityScope = this,
            disc = targetDisc,
            openWebUrl = openWebUrl,
            getTappedDiscJacket = getTappedDiscJacket,
            sharedTransitionScope = sharedTransitionScope,
        )
    }
}
