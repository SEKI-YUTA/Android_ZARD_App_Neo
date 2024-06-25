package com.yuuta.tracklist

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yuuta.app_constant.tooManyTrackList
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.Track
import com.yuuta.ui.BottomNavigationBar
import com.yuuta.ui.CenterMessage
import com.yuuta.ui.TrackList
import com.yuuta.ui.ZARDAppScaffold
import com.yuuta.ui.bottomAppBarData
import com.yuuta.ui.preview.PreviewItemWrapper

@VisibleForTesting
@Composable
fun TrackListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    allTrackList: List<Track>?,
    openWebUrl: (String) -> Unit,
) {
    ZARDAppScaffold(
        openWebUrl = openWebUrl,
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                bottomAppBarItems = bottomAppBarData,
            )
        },
    ) {
        val context = LocalContext.current
        if (allTrackList.isNullOrEmpty()) {
            CenterMessage(context.getString(com.yuuta.resouce.R.string.track_empty_message))
        }
        Box(
            modifier =
                modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(4.dp),
        ) {
            TrackList(
                trackList = allTrackList,
                haveHeadingNumber = false,
                itemTapAction = { track ->
                    // ここで曲をタップされた時のアクションを書く
                },
            )
        }
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun TrackListScreenPreview() {
    PreviewItemWrapper {
        TrackListScreen(
            navController = rememberNavController(),
            allTrackList = tooManyTrackList,
            openWebUrl = {},
        )
    }
}
