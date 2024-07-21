package com.yuuta.androidbenchmark

import android.content.Intent
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScrollBenchmark {

    companion object {
        private const val PACKAGE_NAME = "com.yuuta.zardAppNeo"
    }

    @get:Rule
    val baselineProfileRule = BaselineProfileRule()
//    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun scroll() {
        baselineProfileRule.collect(
            packageName = PACKAGE_NAME
        ) {
            pressHome()
            startActivityAndWait()
            device.wait(Until.findObject(By.desc("discList")), 5000)
            val discList = device.findObject(By.desc("discList"))
            discList.setGestureMargin(device.displayHeight / 5)
            discList.fling(Direction.DOWN)
            device.waitForIdle()
        }
//        benchmarkRule.measureRepeated(
//            packageName = PACKAGE_NAME,
//            metrics = listOf(StartupTimingMetric()),
//            iterations = 1,
//            startupMode = StartupMode.COLD,
//            setupBlock = setupBenchmark()
//        ) {
////            setupBenchmark()
//            pressHome()
//            startActivityAndWait()
//            device.wait(Until.findObject(By.desc("discList")), 5000)
//            val discList = device.findObject(By.desc("discList"))
//            discList.setGestureMargin(device.displayHeight / 5)
//            discList.fling(Direction.DOWN)
//            device.waitForIdle()
//        }
    }
    private fun setupBenchmark(): MacrobenchmarkScope.() -> Unit = {
        pressHome()
        startActivityAndWait()
    }
}
