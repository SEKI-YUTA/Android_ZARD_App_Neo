package com.yuuta.setting

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val SETTING_ROUTE = "ZARDAppNeo/setting"

fun NavController.navigateToSetting() {
    navigate(SETTING_ROUTE)
}

fun NavGraphBuilder.settingRoute() {
    composable(SETTING_ROUTE) {
        SettingScreen()
    }
}
