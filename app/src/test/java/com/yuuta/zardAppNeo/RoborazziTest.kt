package com.yuuta.zardAppNeo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
class RoborazziTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun captureTest() {
        composeRule.setContent {
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text("Hello Roborazzi")
            }
        }

        composeRule.onRoot().captureRoboImage()
    }
}
