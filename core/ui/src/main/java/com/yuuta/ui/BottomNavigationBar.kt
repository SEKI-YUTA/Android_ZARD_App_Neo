package com.yuuta.ui

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import com.yuuta.common.model.BottomAppBarItem
import com.yuuta.disclist.DISC_LIST_ROUTE
import com.yuuta.disclist.navigateToDiscList
import com.yuuta.setting.SETTING_ROUTE
import com.yuuta.setting.navigateToSetting
import com.yuuta.tracklist.TRACK_LIST_ROUTE
import com.yuuta.tracklist.navigateToTrackList

@Composable
fun BottomNavigationBar(
    modifier: Modifier,
    navController: NavController,
    bottomAppBarItems: List<BottomAppBarItem>,
) {
    val selectedRoute = navController.currentDestination?.hierarchy?.first()?.route
    BottomAppBar {

        bottomAppBarItems.forEach { item ->
            NavigationBarItem(
                selected = item.route == selectedRoute,
                onClick = {
                      when(item.route) {
                          DISC_LIST_ROUTE -> navController.navigateToDiscList()
                          TRACK_LIST_ROUTE -> navController.navigateToTrackList()
                          SETTING_ROUTE -> navController.navigateToSetting()
                      }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = "")
                }
            )
        }
    }
}
