package com.yuuta.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppSetting(
    @SerialName("appIconMode")
    val appIconMode: AppIconMode,
) {
    companion object {
        val DEFAULT = AppSetting(
            appIconMode = AppIconMode.LIGHT_ICON,
        )
    }
}
