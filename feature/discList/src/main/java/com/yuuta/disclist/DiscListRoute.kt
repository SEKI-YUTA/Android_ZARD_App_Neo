package com.yuuta.disclist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.common.model.Disc
import com.yuuta.navigation.DISC_LIST_ROUTE

fun NavGraphBuilder.discListScreen(
    navigateToDetail: (String) -> Unit,
    discList: List<Disc>?,
) {
    return composable(DISC_LIST_ROUTE) {
        DiscListScreen(
            navigateToDetail = navigateToDetail,
            discList = discList,
        )
    }
}
