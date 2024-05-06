package com.yuuta.discdetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yuuta.navigation.DISC_DETAIL_ROUTE

fun NavGraphBuilder.discDetailScreen(
    navController: NavController
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
        DiscDetailScreen(
            navController = navController,
        )
    }
}
