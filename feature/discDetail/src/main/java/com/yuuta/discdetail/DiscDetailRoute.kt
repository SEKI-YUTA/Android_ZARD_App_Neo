package com.yuuta.discdetail

import android.graphics.Bitmap
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yuuta.common.model.Disc
import com.yuuta.navigation.DISC_DETAIL_ROUTE

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.discDetailScreen(
    navController: NavController,
    discList: List<Disc>?,
    openWebUrl: (String) -> Unit,
    getTappedDiscJacket: () -> Bitmap,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable(
        "$DISC_DETAIL_ROUTE/{discId}",
        arguments =
            listOf(
                navArgument("discId") {
                    type = NavType.StringType
                },
            ),
    ) {
        val discId = it.arguments?.getString("discId")
        val targetDisc = discList?.find { it.id.toString() == discId }
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
