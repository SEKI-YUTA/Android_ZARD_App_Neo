package com.yuuta.setting

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yuuta.common.model.AppSetting
import com.yuuta.ui.AppIconSetting
import com.yuuta.ui.BottomNavigationBar
import com.yuuta.ui.bottomAppBarData

@Composable
internal fun SettingScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    appSetting: AppSetting?,
    updateAppSetting: (context: Context, appSetting: AppSetting) -> Unit,
) {
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
             BottomNavigationBar(
                 navController = navController,
                 bottomAppBarItems = bottomAppBarData,
             )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                item {
                    appSetting?.let {
                        AppIconSetting(
                            currentAppIconMode = appSetting.appIconMode,
                            onUpdateIcon = {
                                updateAppSetting(context, appSetting.copy(appIconMode = it))
                            }
                        )
                    }
                }
            }
        }
    }
}
