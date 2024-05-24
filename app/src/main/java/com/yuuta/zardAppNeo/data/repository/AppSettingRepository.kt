package com.yuuta.zardAppNeo.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.yuuta.common.model.AppSetting
import com.yuuta.zardAppNeo.PreferenceKeys
import com.yuuta.zardAppNeo.data.contract.AppSettingRepositoryContract
import com.yuuta.zardAppNeo.datastore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AppSettingRepository: AppSettingRepositoryContract {
    override suspend fun readAppSetting(context: Context): Flow<AppSetting> {
        return context.datastore.data.map {
            val appSettingStr = it[PreferenceKeys.APP_SETTING]
            if(appSettingStr != null) {
               Json.decodeFromString<AppSetting>(appSettingStr)
            } else {
                AppSetting.DEFAULT
            }
        }
    }

    override suspend fun writeAppSetting(context: Context, appSetting: AppSetting) {
        context.datastore.edit {
            it[PreferenceKeys.APP_SETTING] = Json.encodeToString(appSetting)
        }
    }
}
