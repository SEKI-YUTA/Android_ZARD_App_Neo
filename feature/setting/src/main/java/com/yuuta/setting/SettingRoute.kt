package com.yuuta.setting

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.navigation.SETTING_ROUTE

fun NavGraphBuilder.settingRoute(
    navController: NavController
) {
    composable(SETTING_ROUTE) {
        SettingScreen(navController = navController)
    }
}
