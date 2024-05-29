package com.yuuta.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yuuta.common.model.Track

@Composable
fun TrackList(
    trackList: List<Track>?,
    haveHeadingNumber: Boolean,
    itemTapAction: (Track) -> Unit,
    headItem: @Composable () -> Unit = {},
) {
    if (trackList == null) return
    LazyColumn {
        item {
            headItem()
        }
        itemsIndexed(
            trackList,
            key = { idx, track -> "$idx:${track.trackName}" },
        ) { index, track ->
            TrackCard(
                trackNumber = if (haveHeadingNumber) index + 1 else null,
                track = track,
                tapCallback = itemTapAction,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackListPreview() {
    val trackList =
        listOf(
            Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
            Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
            Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
            Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
            Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
            Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993"),
        )
    TrackList(
        trackList = trackList,
        haveHeadingNumber = true,
        itemTapAction = {},
        headItem = {},
    )
}
