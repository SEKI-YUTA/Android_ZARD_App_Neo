package com.yuuta.ui

import android.content.Context
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yuuta.common.model.Disc
import com.yuuta.resouce.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSharedTransitionApi::class)
@Composable
fun DiscCard(
    context: Context = LocalContext.current,
    disc: Disc,
    previewMode: Boolean = false,
    animatedVisibilityScope: AnimatedVisibilityScope,
    sharedTransitionScope: SharedTransitionScope,
    onCardTappedAction: () -> Unit,
) {
    val trackCount = disc.trackList.size
    with(sharedTransitionScope) {
        RichTooltipBox(
            text = {
                Column {
                    Text(disc.name)
                    Text(
                        text = disc.trackList.subList(0, if (trackCount > 3) 3 else trackCount)
                            .mapIndexed { idx, track -> "${idx + 1} ${track.trackName}" }
                            .joinToString("\n"),
                    )
                    if (trackCount > 3) Text("...")
                }
            }
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(8.dp)
                    .tooltipAnchor(),
                content = {
                    val withOutExt = disc.imageName.split(".")[0]
                    val imageId =
                        if (previewMode) R.drawable.index1_1991_02_10_1stsingle
                        else context.resources.getIdentifier(
                            withOutExt,
                            "drawable",
                            context.packageName
                        )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(8.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .sharedElement(
                                    state = rememberSharedContentState(key = "disc_image/$imageId"),
                                    animatedVisibilityScope = animatedVisibilityScope,
                                )
                                .padding(8.dp)
                                .width(100.dp)
                                .height(100.dp),
                            painter = painterResource(id = imageId),
                            contentDescription = ""
                        )
                        Column {
                            Text(disc.indexStr, modifier = Modifier.fillMaxWidth())
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    modifier = Modifier
                                        .sharedElement(
                                            state = rememberSharedContentState(key = "disc_name/${disc.id}"),
                                            animatedVisibilityScope = animatedVisibilityScope,
                                        )
                                        .weight(1f),
                                    text = disc.name,
                                    fontSize = 24.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1
                                )
                                Text(
                                    "${disc.trackList.size}${stringResource(id = R.string.track_unit)}",
                                    modifier = Modifier.width(40.dp)
                                )
                            }
                            Text("${disc.releaseYear}${stringResource(id = R.string.year_unit)}")
                        }
                    }
                },
                onClick = {
                    onCardTappedAction()
                }
            )
        }
    }
}

@Preview
@Composable
fun DiscCardPreview() {
    val disc = Disc(
        id = 0,
        name = "Good-bye My Loneliness",
        releaseYear = "1991",
        imageName = "_1991_02_10_1stsingle.jpg",
        discType = "オリジナルアルバム",
        indexStr = "1st",
        trackList = listOf(),
        releaseMonth = "2",
        releaseDate = "10",
        is8cm = true
    )
// animateedVisibitlityScopeの渡し方がわからないので一旦コメントアウト
//    DiscCard(
//        disc = disc,
//        previewMode = true,
//        onCardTappedAction = {},
//    )
}
