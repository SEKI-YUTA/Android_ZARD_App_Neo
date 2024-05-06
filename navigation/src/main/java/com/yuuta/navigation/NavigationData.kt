package com.yuuta.navigation

import androidx.navigation.NavController

val DISC_LIST_ROUTE = "ZARDAppNeo/discList"
val DISC_DETAIL_ROUTE = "ZARDAppNeo/discDetail"
val TRACK_LIST_ROUTE = "ZARDAppNeo/trackList"
val SETTING_ROUTE = "ZARDAppNeo/setting"

fun NavController.navigateToDiscList() {
    navigate(DISC_LIST_ROUTE)
}

fun NavController.navigateToDiscDetail(discId: String) {
    navigate("$DISC_DETAIL_ROUTE/$discId")
}

fun NavController.navigateToTrackList() {
    navigate(TRACK_LIST_ROUTE)
}

fun NavController.navigateToSetting() {
    navigate(SETTING_ROUTE)
}
