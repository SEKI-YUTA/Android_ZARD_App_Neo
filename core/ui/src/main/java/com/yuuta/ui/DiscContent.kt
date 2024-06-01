package com.yuuta.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yuuta.common.model.Disc
import com.yuuta.common.model.Track
import com.yuuta.resouce.R

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
