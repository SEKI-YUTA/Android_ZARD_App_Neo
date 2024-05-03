package com.yuuta.setting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val SETTING_ROUTE = "ZARDAppNeo/setting"

fun NavGraphBuilder.settingRoute() {
    composable(SETTING_ROUTE) {
        SettingScreen()
    }
}
