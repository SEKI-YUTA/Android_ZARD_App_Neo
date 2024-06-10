package com.yuuta.setting

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yuuta.common.model.AppSetting
import com.yuuta.navigation.SETTING_ROUTE

fun NavGraphBuilder.settingRoute(
    navController: NavController,
    appSetting: AppSetting?,
    updateAppSetting: (context: Context, appSetting: AppSetting) -> Unit,
    openWebUrl: (String) -> Unit,
) {
    composable(SETTING_ROUTE) {
        SettingScreen(
            navController = navController,
            appSetting = appSetting,
            updateAppSetting = updateAppSetting,
            openWebUrl = openWebUrl,
        )
    }
}
