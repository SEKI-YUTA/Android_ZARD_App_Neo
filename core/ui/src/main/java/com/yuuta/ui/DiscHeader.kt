package com.yuuta.ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yuuta.resouce.R

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
