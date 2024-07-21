package com.yuuta.zardAppNeo.data

import org.junit.Test
import sergio.sastre.composable.preview.scanner.android.AndroidComposablePreviewScanner

class GetPreviewsTest {
    @Test
    fun hgoe() {
        AndroidComposablePreviewScanner()
            .scanPackageTrees("com.yuuta", "zardAppNeo")
            // options to filter scanned previews
            .includePrivatePreviews() // Otherwise they are ignored
            .filterPreviews {
                // filter by any previewInfo: name, group, apiLevel, locale, uiMode, fontScale...
                    previewInfo ->  previewInfo.apiLevel == 30
            }
            // ---
            .getPreviews()
    }
}
