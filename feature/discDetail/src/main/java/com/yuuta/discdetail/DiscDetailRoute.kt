package com.yuuta.discdetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

val DISC_DETAIL_ROUTE = "ZARDAppNeo/discDetail"

fun NavController.navigateToDiscDetail(discId: String) {
    navigate("$DISC_DETAIL_ROUTE/$discId")
}

fun NavGraphBuilder.discDetailScreen() {
    composable(
        "$DISC_DETAIL_ROUTE/{discId}" ,
        arguments = listOf(
            navArgument("discId") {
                type = NavType.StringType
            }
        )
    ) {
        val discId = it.arguments?.getString("discId")
        DiscDetailScreen()
    }
}
