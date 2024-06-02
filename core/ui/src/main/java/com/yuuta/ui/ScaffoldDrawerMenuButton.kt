package com.yuuta.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate

@Composable
fun ScaffoldMenuButton(
    animationValue: Float,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = Modifier.rotate((animationValue * 1.8).toFloat()),
        onClick = onClick,
    ) {
        Icon(
            modifier = Modifier.alpha(1f - (animationValue / 100f)),
            imageVector = Icons.Rounded.Menu,
            contentDescription = "Menu",
        )
        Icon(
            modifier = Modifier.alpha(animationValue / 100f),
            imageVector = Icons.Rounded.Close,
            contentDescription = "Close",
        )
    }
}
