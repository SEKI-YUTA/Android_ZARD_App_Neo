package com.yuuta.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.Track
import com.yuuta.ui.preview.PreviewItemWrapper

@Composable
fun TrackCard(
    track: Track,
    trackNumber: Int?,
    tapCallback: (Track) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (trackNumber != null) {
                Text("$trackNumber.", modifier = Modifier.padding(8.dp))
            }
            Text(
                text = track.trackName,
                modifier =
                    Modifier
                        .weight(1f)
                        .padding(8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${track.year}${stringResource(id = com.yuuta.resouce.R.string.year_unit)}",
                modifier = Modifier.padding(end = 8.dp),
            )
        }
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun TrackCardPreview() {
    val track = Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993")
    PreviewItemWrapper {
        TrackCard(trackNumber = null, track = track, tapCallback = {})
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun TrackCardPreview2() {
    val track = Track("負けないで", "坂井泉水", "織田哲郎", "葉山たけし", "1993")
    PreviewItemWrapper {
        TrackCard(trackNumber = 1, track = track, tapCallback = {})
    }
}
