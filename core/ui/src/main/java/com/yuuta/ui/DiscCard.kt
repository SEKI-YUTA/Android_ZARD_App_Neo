package com.yuuta.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valentinilk.shimmer.shimmer
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.Disc
import com.yuuta.resouce.R
import com.yuuta.ui.preview.PreviewItemWrapper

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DiscCard(
    context: Context = LocalContext.current,
    disc: Disc,
    isPreviewMode: Boolean = false,
    animatedVisibilityScope: AnimatedVisibilityScope?,
    sharedTransitionScope: SharedTransitionScope?,
    onCardTappedAction: () -> Unit,
) {
    if (isPreviewMode) {
        DiscCard(
            context = context,
            disc = disc,
            onCardTappedAction = onCardTappedAction,
        )
    } else {
        DiscCard(
            context = context,
            disc = disc,
            animatedVisibilityScope = animatedVisibilityScope!!,
            sharedTransitionScope = sharedTransitionScope!!,
            onCardTappedAction = onCardTappedAction,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
internal fun DiscCard(
    context: Context = LocalContext.current,
    disc: Disc,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onCardTappedAction: () -> Unit,
) {
    val trackCount = disc.trackList.size
    var discJacket: Bitmap? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(key1 = true) {
        discJacket = BitmapFactory.decodeStream(context.assets.open(disc.imageName))
    }
    with(sharedTransitionScope) {
        RichTooltipBox(
            text = {
                Column {
                    Text(disc.name)
                    Text(
                        text =
                            disc.trackList.subList(0, if (trackCount > 3) 3 else trackCount)
                                .mapIndexed { idx, track -> "${idx + 1} ${track.trackName}" }
                                .joinToString("\n"),
                    )
                    if (trackCount > 3) Text("...")
                }
            },
        ) {
            Card(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(8.dp)
                    .tooltipAnchor(),
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier =
                        Modifier
                            .fillMaxHeight()
                            .padding(8.dp),
                    ) {
                        if(discJacket != null) {
                            Image(
                                modifier =
                                Modifier
                                    .padding(8.dp)
                                    .width(100.dp)
                                    .height(100.dp),
                                bitmap = discJacket!!.asImageBitmap(),
                                contentDescription = "",
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(100.dp)
                                    .shimmer()
                                    .background(Color.Gray)
                            )
                        }
                        Column {
                            Text(disc.indexStr, modifier = Modifier.fillMaxWidth())
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Text(
                                    modifier =
                                    Modifier
                                        .sharedElement(
                                            state = rememberSharedContentState(key = "disc_name/${disc.id}"),
                                            animatedVisibilityScope = animatedVisibilityScope,
                                        )
                                        .weight(1f),
                                    text = disc.name,
                                    fontSize = 24.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                )
                                Text(
                                    "${disc.trackList.size}${stringResource(id = R.string.track_unit)}",
                                    modifier = Modifier.width(40.dp),
                                )
                            }
                            Text("${disc.releaseYear}${stringResource(id = R.string.year_unit)}")
                        }
                    }
                },
                onClick = {
                    onCardTappedAction()
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DiscCard(
    context: Context = LocalContext.current,
    disc: Disc,
    onCardTappedAction: () -> Unit,
) {
    val trackCount = disc.trackList.size
    RichTooltipBox(
        text = {
            Column {
                Text(disc.name)
                Text(
                    text =
                        disc.trackList.subList(0, if (trackCount > 3) 3 else trackCount)
                            .mapIndexed { idx, track -> "${idx + 1} ${track.trackName}" }
                            .joinToString("\n"),
                )
                if (trackCount > 3) Text("...")
            }
        },
    ) {
        Card(
            modifier =
            Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(8.dp)
                .tooltipAnchor(),
            content = {
                val withOutExt = disc.imageName.split(".")[0]
                val imageId =
                    R.drawable.index1_1991_02_10_1stsingle
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier =
                    Modifier
                        .fillMaxHeight()
                        .padding(8.dp),
                ) {
                    Image(
                        modifier =
                        Modifier
                            .padding(8.dp)
                            .width(100.dp)
                            .height(100.dp),
                        painter = painterResource(id = imageId),
                        contentDescription = "",
                    )
                    Column {
                        Text(disc.indexStr, modifier = Modifier.fillMaxWidth())
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                modifier =
                                    Modifier
                                        .weight(1f),
                                text = disc.name,
                                fontSize = 24.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1,
                            )
                            Text(
                                "${disc.trackList.size}${stringResource(id = R.string.track_unit)}",
                                modifier = Modifier.width(40.dp),
                            )
                        }
                        Text("${disc.releaseYear}${stringResource(id = R.string.year_unit)}")
                    }
                }
            },
            onClick = {
                onCardTappedAction()
            },
        )
    }
}

// 本来このコンポーザブルはディスクの画像読み込み中に表示させるつもりだったが、画像以外は表示できるはずなので使わなかった。
// 現状ディスク一覧データを読み込んでいる際の読み込み中のアニメーションなどは未実装
// もし実装する場合はShimmerDiscCardを利用して実装する。
@Composable
fun ShimmerDiscCard() {
    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(8.dp),
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                Modifier
                    .fillMaxHeight()
                    .padding(8.dp),
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(100.dp)
                        .shimmer()
                        .background(Color.Gray)
                )
                Column {
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .width(100.dp)
                            .height(20.dp)
                            .shimmer()
                            .background(Color.Gray)
                    )
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .width(200.dp)
                            .height(30.dp)
                            .shimmer()
                            .background(Color.Gray)
                    )
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .width(100.dp)
                            .height(20.dp)
                            .shimmer()
                            .background(Color.Gray)
                    )
                }
            }
        },
    )
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun ShimmerDiscCardPreview() {
    PreviewItemWrapper {
        ShimmerDiscCard()
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@ZARDAppNeoPreviewAnnotation
@Composable
fun DiscCardPreview() {
    val disc =
        Disc(
            id = 0,
            name = "Good-bye My Loneliness",
            releaseYear = "1991",
            imageName = "_1991_02_10_1stsingle.jpg",
            discType = "オリジナルアルバム",
            indexStr = "1st Single",
            trackList = listOf(),
            releaseMonth = "2",
            releaseDate = "10",
            is8cm = true,
            officialPageURL = "",
        )
    PreviewItemWrapper {
        DiscCard(
            disc = disc,
            isPreviewMode = true,
            animatedVisibilityScope = null,
            sharedTransitionScope = null,
        ) {}
    }
}
