package com.yuuta.disclist

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.Disc
import com.yuuta.common.model.Track
import com.yuuta.ui.BottomNavigationBar
import com.yuuta.ui.DiscCard
import com.yuuta.ui.ZARDAppScaffold
import com.yuuta.ui.bottomAppBarData
import com.yuuta.ui.preview.PreviewItemWrapper

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscListScreen(
    modifier: Modifier = Modifier,
    isPreviewMode: Boolean = false,
    navController: NavController,
    navigateToDetail: (String) -> Unit,
    discList: List<Disc>?,
    openWebUrl: (String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope?,
    sharedTransitionScope: SharedTransitionScope?,
) {
    if (isPreviewMode) {
        DiscListScreen(
            modifier = modifier,
            navController = navController,
            navigateToDetail = navigateToDetail,
            discList = discList,
        )
    } else {
        DiscListScreen(
            modifier = modifier,
            navController = navController,
            navigateToDetail = navigateToDetail,
            discList = discList,
            openWebUrl = openWebUrl,
            animatedVisibilityScope = animatedVisibilityScope!!,
            sharedTransitionScope = sharedTransitionScope!!,
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DiscListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateToDetail: (String) -> Unit,
    discList: List<Disc>?,
    openWebUrl: (String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
) {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()
    ZARDAppScaffold(
        openWebUrl = openWebUrl,
        modifier = modifier,
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                bottomAppBarItems = bottomAppBarData,
            )
        },
    ) {
        if (discList == null) return@ZARDAppScaffold
        LazyColumn(
            modifier = Modifier.padding(it),
            state = lazyListState,
            verticalArrangement = Arrangement.Top,
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

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
private fun DiscListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateToDetail: (String) -> Unit,
    discList: List<Disc>?,
) {
    val context = LocalContext.current
    val lazyListState = rememberLazyListState()
    ZARDAppScaffold(
        modifier = modifier,
        openWebUrl = {},
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                bottomAppBarItems = bottomAppBarData,
            )
        },
    ) {
        if (discList == null) return@ZARDAppScaffold
        LazyColumn(
            modifier = Modifier.padding(it),
            state = lazyListState,
            verticalArrangement = Arrangement.Top,
        ) {
            items(discList, key = { it.id }) { disc ->
                DiscCard(
                    context = context,
                    isPreviewMode = true,
                    disc = disc,
                    animatedVisibilityScope = null,
                    sharedTransitionScope = null,
                ) {
                    navigateToDetail(disc.id.toString())
                }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@ZARDAppNeoPreviewAnnotation
@Composable
fun DiscListScreenPreview() {
    val discList =
        listOf(
            Disc(
                id = 1,
                name = "Goodby My Loneliness",
                releaseYear = "1991",
                releaseMonth = "02",
                releaseDate = "10",
                indexStr = "1st Single",
                is8cm = true,
                imageName = "index1_1991_02_10_1stsingle",
                discType = "Single",
                trackList =
                    listOf(
                        Track(
                            trackName = "Goodbye My Loneliness",
                            lyrics = "坂井泉水",
                            composition = "織田哲郎",
                            arrangement = "葉山たけし",
                            year = "1991",
                        ),
                        Track(
                            trackName = "Goodbye My Loneliness",
                            lyrics = "坂井泉水",
                            composition = "織田哲郎",
                            arrangement = "葉山たけし",
                            year = "1991",
                        ),
                    ),
                officialPageURL = "",
            ),
        )
    PreviewItemWrapper {
        DiscListScreen(
            navController = rememberNavController(),
            isPreviewMode = true,
            navigateToDetail = {},
            discList = discList,
            openWebUrl = {},
            animatedVisibilityScope = null,
            sharedTransitionScope = null,
        )
    }
}
