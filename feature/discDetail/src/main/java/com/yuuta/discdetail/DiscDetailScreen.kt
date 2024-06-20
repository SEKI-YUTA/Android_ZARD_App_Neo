package com.yuuta.discdetail

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.Disc
import com.yuuta.common.model.Track
import com.yuuta.resouce.R
import com.yuuta.ui.CenterMessage
import com.yuuta.ui.DiscContent
import com.yuuta.ui.DiscHeader
import com.yuuta.ui.preview.PreviewItemWrapper

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscDetailScreen(
    modifier: Modifier = Modifier,
    isPreviewMode: Boolean = false,
    navController: NavController,
    disc: Disc?,
    openWebUrl: (String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope?,
    sharedTransitionScope: SharedTransitionScope?,
) {
    if (isPreviewMode) {
        DiscDetailScreen(
            modifier = modifier,
            navController = navController,
            disc = disc,
        )
    } else {
        DiscDetailScreen(
            modifier = modifier,
            navController = navController,
            disc = disc,
            openWebUrl = openWebUrl,
            animatedVisibilityScope = animatedVisibilityScope!!,
            sharedTransitionScope = sharedTransitionScope!!,
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    disc: Disc?,
    openWebUrl: (String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
) {
    Scaffold(
        modifier = modifier,
    ) {
        val context = LocalContext.current
        if (disc == null) {
            CenterMessage(context.getString(R.string.error_message))
            return@Scaffold
        }
        val withOutExt = disc.imageName.split(".")[0]
        val imageId =
            context.resources.getIdentifier(
                withOutExt,
                "drawable",
                context.packageName,
            )
        Column(
            modifier =
                Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp),
        ) {
            DiscHeader(
                discId = disc.id,
                imageId = imageId,
                name = disc.name,
                releaseYear = disc.releaseYear,
                trackCount = disc.trackList.size,
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope,
            )
            DiscContent(
                modifier = Modifier.weight(1f),
                disc = disc,
                showBottomSheet = {},
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                ElevatedButton(onClick = {
                    Intent(Intent.ACTION_VIEW).let {
                        it.data = Uri.parse(disc.officialPageURL)
                        if (it.resolveActivity(context.packageManager) != null) {
                            context.startActivity(it)
                        } else {
                            Toast
                                .makeText(
                                    context,
                                    "ブラウザが見つかりませんでした。",
                                    Toast.LENGTH_SHORT,
                                )
                                .show()
                        }
                    }
                }) {
                    Text("WEZARDで見る")
                    Icon(
                        Icons.Rounded.KeyboardArrowRight,
                        contentDescription = "",
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    disc: Disc?,
) {
    Scaffold(
        modifier = modifier,
    ) {
        val context = LocalContext.current
        if (disc == null) {
            CenterMessage(context.getString(R.string.error_message))
            return@Scaffold
        }
        val withOutExt = disc.imageName.split(".")[0]
        val imageId = R.drawable.index1_1991_02_10_1stsingle

        Column(
            modifier =
                Modifier
                    .padding(it)
                    .fillMaxSize()
                    .padding(16.dp),
        ) {
            DiscHeader(
                discId = disc.id,
                imageId = imageId,
                name = disc.name,
                releaseYear = disc.releaseYear,
                trackCount = disc.trackList.size,
            )
            DiscContent(
                modifier = Modifier.weight(1f),
                disc = disc,
                showBottomSheet = {},
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                ElevatedButton(onClick = {
                    Intent(Intent.ACTION_VIEW).let {
                        it.data = Uri.parse(disc.officialPageURL)
                        if (it.resolveActivity(context.packageManager) != null) {
                            context.startActivity(it)
                        } else {
                            Toast
                                .makeText(
                                    context,
                                    "ブラウザが見つかりませんでした。",
                                    Toast.LENGTH_SHORT,
                                )
                                .show()
                        }
                    }
                }) {
                    Text("WEZARDで見る")
                    Icon(
                        Icons.Rounded.KeyboardArrowRight,
                        contentDescription = "",
                    )
                }
            }
        }
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun DiscDetailScreenPreview() {
    // ここででもデータを用意する
    val disc =
        Disc(
            id = 1,
            name = "Good-bye My Loneliness",
            releaseYear = "1993",
            imageName = "index1_1991_02_10_1stsingle.jpg",
            officialPageURL = "https://www.wezard.net/",
            discType = "シングル",
            indexStr = "1st Single",
            releaseMonth = "2",
            releaseDate = "10",
            is8cm = true,
            trackList =
                listOf(
                    Track("Good-bye My Loneliness", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
                    Track("Good-bye My Loneliness", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
                    Track("Good-bye My Loneliness", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
                    Track("Good-bye My Loneliness", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
                    Track("Good-bye My Loneliness", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
                ),
        )
    PreviewItemWrapper {
        DiscDetailScreen(
            navController = rememberNavController(),
            disc = disc,
        )
    }
}
