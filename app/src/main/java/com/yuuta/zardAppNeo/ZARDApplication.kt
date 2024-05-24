package com.yuuta.zardAppNeo

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.HiltAndroidApp

internal const val APP_SETTING_PREFERENCE_NAME = "zard_app_preference_key"
internal val Context.datastore by preferencesDataStore(name = APP_SETTING_PREFERENCE_NAME)

internal object PreferenceKeys {
    val APP_SETTING = stringPreferencesKey("app_setting")
}

@HiltAndroidApp
class ZARDApplication : Application()
