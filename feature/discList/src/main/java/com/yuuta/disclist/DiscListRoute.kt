package com.yuuta.disclist

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.common.model.Disc
import com.yuuta.navigation.DISC_LIST_ROUTE

@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.discListScreen(
    navController: NavController,
    navigateToDetail: (String) -> Unit,
    discList: List<Disc>?,
    sharedTransitionScope: SharedTransitionScope,
) {
    return composable(DISC_LIST_ROUTE) {
        DiscListScreen(
            navController = navController,
            navigateToDetail = navigateToDetail,
            discList = discList,
            animatedVisibilityScope = this,
            sharedTransitionScope = sharedTransitionScope,
        )
    }
}
