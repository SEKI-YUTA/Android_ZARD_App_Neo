package com.yuuta.tracklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yuuta.common.model.Track
import com.yuuta.ui.BottomNavigationBar
import com.yuuta.ui.CenterMessage
import com.yuuta.ui.TrackList
import com.yuuta.ui.ZARDAppScaffold
import com.yuuta.ui.bottomAppBarData

@Composable
internal fun TrackListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    allTrackList: List<Track>?,
) {
    ZARDAppScaffold(
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
                Modifier
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
