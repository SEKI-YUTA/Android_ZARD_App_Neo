package com.yuuta.disclist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val DISC_LIST_ROUTE = "ZARDAppNeo/discList"

fun NavGraphBuilder.discListScreen(
    navigateToDetail: (String) -> Unit
) {
    return composable(DISC_LIST_ROUTE) {
        DiscListScreen(navigateToDetail = navigateToDetail)
    }
}
