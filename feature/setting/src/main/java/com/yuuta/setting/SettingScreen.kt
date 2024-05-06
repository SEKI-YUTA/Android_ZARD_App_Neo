package com.yuuta.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
internal fun SettingScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Scaffold {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("SettingScreen")
        }
    }
}
