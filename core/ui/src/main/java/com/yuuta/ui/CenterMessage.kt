package com.yuuta.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yuuta.common.annotation.ZARDAppNeoPreviewAnnotation
import com.yuuta.ui.preview.PreviewItemWrapper

@Composable
fun CenterMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(message)
    }
}

@ZARDAppNeoPreviewAnnotation
@Composable
fun CenterMessagePreview() {
    PreviewItemWrapper {
        CenterMessage("Hello, World!")
    }
}
