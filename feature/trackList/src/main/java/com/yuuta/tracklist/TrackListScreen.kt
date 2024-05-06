package com.yuuta.tracklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.yuuta.ui.BottomNavigationBar
import com.yuuta.ui.bottomAppBarData

@Composable
internal fun TrackListScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                bottomAppBarItems = bottomAppBarData,
            )
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("TrackListScreen")
        }
    }
}
