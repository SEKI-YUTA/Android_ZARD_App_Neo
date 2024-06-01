package com.yuuta.ui.preview

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.yuuta.resource.theme.ZARD_AppNeoTheme

@Composable
fun PreviewItemWrapper(
    previewContent: @Composable () -> Unit,
) {
    ZARD_AppNeoTheme {
        Surface {
            previewContent()
        }
    }
}
