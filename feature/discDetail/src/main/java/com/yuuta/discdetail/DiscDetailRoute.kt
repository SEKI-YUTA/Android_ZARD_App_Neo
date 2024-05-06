package com.yuuta.discdetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yuuta.common.model.Disc
import com.yuuta.navigation.DISC_DETAIL_ROUTE

fun NavGraphBuilder.discDetailScreen(
    navController: NavController,
    discList: List<Disc>?,
) {
    composable(
        "$DISC_DETAIL_ROUTE/{discId}" ,
        arguments = listOf(
            navArgument("discId") {
                type = NavType.StringType
            }
        )
    ) {
        val discId = it.arguments?.getString("discId")
        val targetDisc = discList?.find { it.id.toString() == discId }
        DiscDetailScreen(
            navController = navController,
            disc = targetDisc
        )
    }
}
