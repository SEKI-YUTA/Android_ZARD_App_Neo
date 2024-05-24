package com.yuuta.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yuuta.common.model.AppIconMode
import com.yuuta.resouce.R

@Composable
fun AppIconSetting(
    modifier: Modifier = Modifier,
    currentAppIconMode: AppIconMode,
    onUpdateIcon: (AppIconMode) -> Unit,
) {
    var test by remember {
        mutableStateOf(AppIconMode.LIGHT_ICON)
    }
    val isLightIcon = remember(test) {
        derivedStateOf {
            test == AppIconMode.LIGHT_ICON
        }
    }.value
//    val isLightIcon = currentAppIconMode == AppIconMode.LIGHT_ICON
    Column {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = stringResource(R.string.setting_app_icon),
            style = MaterialTheme.typography.bodyLarge
        )
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(R.drawable.app_logo_dark),
                contentDescription = "",
            )
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = if (isLightIcon) "Light" else "Dark",
                )
                Switch(checked = isLightIcon, onCheckedChange = {
                    println("onCheckedChange: ${if(it) "Light" else "Dark"}")
                    onUpdateIcon(if (it) AppIconMode.LIGHT_ICON else AppIconMode.DARK_ICON)
                    test = if (it) AppIconMode.LIGHT_ICON else AppIconMode.DARK_ICON
                })
            }
        }
    }
}

@Preview
@Composable
fun AppIconSettingPreview() {
    AppIconSetting(currentAppIconMode = AppIconMode.LIGHT_ICON, onUpdateIcon = {})
}
