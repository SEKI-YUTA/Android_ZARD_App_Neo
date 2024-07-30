package com.yuuta.disclist

import android.graphics.Bitmap
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
    openWebUrl: (String) -> Unit,
    setTappedDiscJacket: (Bitmap) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
) {
    return composable(DISC_LIST_ROUTE) {
        DiscListScreen(
            navController = navController,
            navigateToDetail = navigateToDetail,
            discList = discList,
            setTappedDiscJacket = setTappedDiscJacket,
            openWebUrl = openWebUrl,
            animatedVisibilityScope = this,
            sharedTransitionScope = sharedTransitionScope,
        )
    }
}
