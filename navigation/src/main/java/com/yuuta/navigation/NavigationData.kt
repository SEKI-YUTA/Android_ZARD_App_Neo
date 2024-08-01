package com.yuuta.navigation

import androidx.navigation.NavController
import com.yuuta.common.model.NavigationDestination

fun NavController.navigateToDiscList() {
    navigate(NavigationDestination.DiscList)
}

fun NavController.navigateToDiscDetail(discId: String) {
    navigate(NavigationDestination.DiscDetail(discId))
}

fun NavController.navigateToTrackList() {
    navigate(NavigationDestination.TrackList)
}

fun NavController.navigateToSetting() {
    navigate(NavigationDestination.Setting)
}
