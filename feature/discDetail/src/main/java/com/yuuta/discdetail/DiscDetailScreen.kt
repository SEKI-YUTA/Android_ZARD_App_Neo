package com.yuuta.discdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.yuuta.common.model.Disc

@Composable
internal fun DiscDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    disc: Disc?,
) {
    Scaffold {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("DiscDetailScreen")
        }
    }
}
