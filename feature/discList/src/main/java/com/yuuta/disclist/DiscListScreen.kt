package com.yuuta.disclist

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.yuuta.common.model.Disc
import com.yuuta.ui.BottomNavigationBar
import com.yuuta.ui.DiscCard
import com.yuuta.ui.bottomAppBarData

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateToDetail: (String) -> Unit,
    discList: List<Disc>?,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
) {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()
    with(sharedTransitionScope) {
        Scaffold(
            modifier = modifier,
            bottomBar = {
                BottomNavigationBar(
                    navController = navController,
                    bottomAppBarItems = bottomAppBarData
                )
            }
        ) {
            if (discList == null) return@Scaffold
            LazyColumn(
                modifier = Modifier.padding(it),
                state = lazyListState,
                verticalArrangement = Arrangement.Top
            ) {
                items(discList, key = { it.id }) { disc ->
                    DiscCard(
                        context = context,
                        disc = disc,
                        animatedVisibilityScope = animatedVisibilityScope,
                        sharedTransitionScope = sharedTransitionScope,
                    ) {
                        navigateToDetail(disc.id.toString())
                    }
                }
            }
        }
    }
}
