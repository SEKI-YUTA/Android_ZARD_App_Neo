package com.yuuta.zardAppNeo.data.contract

import android.content.Context
import com.yuuta.common.model.AppSetting
import kotlinx.coroutines.flow.Flow

interface AppSettingRepositoryContract {
    suspend fun readAppSetting(context: Context): Flow<AppSetting>
    suspend fun writeAppSetting(context: Context, appSetting: AppSetting)
}
