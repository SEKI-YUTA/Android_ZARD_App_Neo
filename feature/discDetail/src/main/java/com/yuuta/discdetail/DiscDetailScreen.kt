package com.yuuta.discdetail

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.Disc
import com.yuuta.common.model.Track
import com.yuuta.resouce.R
import com.yuuta.ui.CenterMessage
import com.yuuta.ui.TrackList
import com.yuuta.ui.preview.PreviewItemWrapper

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscDetailScreen(
    modifier: Modifier = Modifier,
    isPreviewMode: Boolean = false,
    navController: NavController,
    disc: Disc?,
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
                Text(
                    modifier =
                    Modifier
                        .clickable {
                            Intent(Intent.ACTION_VIEW).let {
                                it.data = Uri.parse(disc.officialPageURL)
                                if (it.resolveActivity(context.packageManager) != null) {
                                    context.startActivity(it)
                                } else {
                                    Toast
                                        .makeText(
                                            context,
                                            "ブラウザが見つかりませんでした。",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            }
                        }
                        .padding(8.dp),
                    text = "WEZARDで見る",
                    fontSize = 16.sp,
                    style =
                    TextStyle(
                        color =
                        if (isSystemInDarkTheme()) {
                            Color.White
                        } else {
                            Color.Blue.copy(alpha = 0.6f)
                        },
                        textDecoration = TextDecoration.Underline,
                    ),
                    overflow = TextOverflow.Ellipsis,
                )
                Icon(
                    Icons.Rounded.ArrowForward,
                    contentDescription = "",
                )
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
                Text(
                    modifier =
                    Modifier
                        .clickable {
                            Intent(Intent.ACTION_VIEW).let {
                                it.data = Uri.parse(disc.officialPageURL)
                                if (it.resolveActivity(context.packageManager) != null) {
                                    context.startActivity(it)
                                } else {
                                    Toast
                                        .makeText(
                                            context,
                                            "ブラウザが見つかりませんでした。",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            }
                        }
                        .padding(8.dp),
                    text = "WEZARDで見る",
                    fontSize = 16.sp,
                    style =
                    TextStyle(
                        color =
                        if (isSystemInDarkTheme()) {
                            Color.White
                        } else {
                            Color.Blue.copy(alpha = 0.6f)
                        },
                        textDecoration = TextDecoration.Underline,
                    ),
                    overflow = TextOverflow.Ellipsis,
                )
                Icon(
                    Icons.Rounded.ArrowForward,
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
fun DiscContent(
    modifier: Modifier = Modifier,
    disc: Disc,
    showBottomSheet: (Track) -> Unit = {},
) {
    Column(modifier = modifier) {
        TrackList(
            trackList = disc.trackList,
            haveHeadingNumber = true,
            headItem =
            {
                Text(
                    text = stringResource(id = R.string.recorded_track),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp,
                )
            },
            itemTapAction = { track ->
                showBottomSheet(track)
            },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun DiscHeader(
    discId: Int,
    imageId: Int,
    name: String,
    releaseYear: String,
    trackCount: Int,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
) {
    with(sharedTransitionScope) {
        Row(
            modifier =
            Modifier
                .padding(4.dp)
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "",
                modifier =
                Modifier
                    .sharedElement(
                        state = rememberSharedContentState(key = "disc_image/$imageId"),
                        animatedVisibilityScope = animatedVisibilityScope,
                    )
                    .width(140.dp)
                    .height(140.dp),
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp),
            ) {
                PlainTooltipBox(
                    tooltip = {
                        Text(name)
                    },
                ) {
                    Text(
                        modifier =
                        Modifier
                            .tooltipAnchor()
                            .sharedElement(
                                state = rememberSharedContentState(key = "disc_name/$discId"),
                                animatedVisibilityScope = animatedVisibilityScope,
                            ),
                        text = name,
                        fontSize = 30.sp,
                        maxLines = 2,
                        lineHeight = 36.sp,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Text("${releaseYear}${stringResource(id = R.string.year_unit)}")
                Text("${trackCount}${stringResource(id = R.string.track_unit)}")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun DiscHeader(
    discId: Int,
    imageId: Int,
    name: String,
    releaseYear: String,
    trackCount: Int,
) {
    Row(
        modifier =
        Modifier
            .padding(4.dp)
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "",
            modifier =
            Modifier
                .width(140.dp)
                .height(140.dp),
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp),
        ) {
            PlainTooltipBox(
                tooltip = {
                    Text(name)
                },
            ) {
                Text(
                    modifier =
                    Modifier
                        .tooltipAnchor(),
                    text = name,
                    fontSize = 30.sp,
                    maxLines = 2,
                    lineHeight = 36.sp,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Text("${releaseYear}${stringResource(id = R.string.year_unit)}")
            Text("${trackCount}${stringResource(id = R.string.track_unit)}")
        }
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun DiscDetailScreenPreview() {
    // ここででもデータを用意する
    val disc = Disc(
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
        trackList = listOf(
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
