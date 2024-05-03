package com.yuuta.discdetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val DISC_DETAIL_ROUTE = "ZARDAppNeo/discDetail"

fun NavGraphBuilder.discDetailScreen() {
    composable(DISC_DETAIL_ROUTE) {
        DiscDetailScreen()
    }
}
