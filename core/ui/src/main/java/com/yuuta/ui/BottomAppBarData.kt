package com.yuuta.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Settings
import com.yuuta.common.model.BottomAppBarItem
import com.yuuta.common.model.NavigationDestination

val bottomAppBarData =
    listOf(
        BottomAppBarItem(
            icon = Icons.Rounded.List,
            text = "CD一覧",
            route = NavigationDestination.DiscList,
        ),
        BottomAppBarItem(
            icon = Icons.Rounded.MusicNote,
            text = "曲一覧",
            route = NavigationDestination.TrackList,
        ),
        BottomAppBarItem(
            icon = Icons.Rounded.Settings,
            text = "設定",
            route = NavigationDestination.Setting,
        ),
    )
