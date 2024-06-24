package com.yuuta.zardAppNeo

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.navigation.compose.rememberNavController
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import com.yuuta.app_constant.discList
import com.yuuta.app_constant.tooManyTrackList
import com.yuuta.discdetail.DiscDetailScreen
import com.yuuta.disclist.DiscListScreen
import com.yuuta.setting.SettingScreen
import com.yuuta.tracklist.TrackListScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel7)
class CaptureZARDAppUITest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun captureDiscListScreen() {
        composeRule
            .setContent {
                DiscListScreen(
                    navController = rememberNavController(),
                    navigateToDetail = {},
                    discList = discList,
                )
            }

        composeRule.onRoot().captureRoboImage()
    }

    @Test
    fun captureDiscDetailScreen() {
        composeRule
            .setContent {
                DiscDetailScreen(
                    navController = rememberNavController(),
                    disc = discList.first(),
                )
            }

        composeRule.onRoot().captureRoboImage()
    }

    @Test
    fun captureTrackListScreen() {
        composeRule
            .setContent {
                TrackListScreen(
                    navController = rememberNavController(),
                    openWebUrl = {},
                    allTrackList = tooManyTrackList,
                )
            }

        composeRule.onRoot().captureRoboImage()
    }

    @Test
    fun captureSettingScreen() {
        composeRule
            .setContent {
                SettingScreen(
                    navController = rememberNavController(),
                    openWebUrl = {},
                    appSetting = null,
                    updateAppSetting = { _, _ -> },
                )
            }

        composeRule.onRoot().captureRoboImage()
    }
}
