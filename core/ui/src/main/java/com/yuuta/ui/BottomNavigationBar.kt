package com.yuuta.ui

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.common.model.BottomAppBarItem
import com.yuuta.common.model.NavigationDestination
import com.yuuta.navigation.navigateToDiscList
import com.yuuta.navigation.navigateToSetting
import com.yuuta.navigation.navigateToTrackList
import com.yuuta.ui.preview.PreviewItemWrapper

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    bottomAppBarItems: List<BottomAppBarItem>,
) {
    val selectedRoute = navController.currentDestination?.hierarchy?.first()?.route
    BottomAppBar {
        bottomAppBarItems.forEach { item ->
            NavigationBarItem(
                selected = item.route::class.qualifiedName == selectedRoute,
                onClick = {
                    when (item.route) {
                        NavigationDestination.DiscList -> navController.navigateToDiscList()
                        NavigationDestination.TrackList -> navController.navigateToTrackList()
                        NavigationDestination.Setting -> navController.navigateToSetting()
                        else -> {
                            // NavigationDestinationにはDiscDetailがあるがボトムナビゲーションから遷移されないのでelseで握りつぶす
                        }
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = "")
                },
                label = {
                    Text(item.text)
                },
            )
        }
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun BottomNavigationBarPreview() {
    PreviewItemWrapper {
        BottomNavigationBar(navController = rememberNavController(), bottomAppBarItems = bottomAppBarData)
    }
}
