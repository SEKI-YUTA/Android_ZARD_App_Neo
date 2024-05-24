package com.yuuta.zardAppNeo.ui.viewmodel

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuuta.common.model.AppIconMode
import com.yuuta.common.model.AppSetting
import com.yuuta.common.model.ArtistInformation
import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.repository.AppSettingRepository
import com.yuuta.zardAppNeo.data.repository.ArtistInformationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ZARDAppViewModel
@Inject
constructor(
    artistInformationRepository: ArtistInformationRepository,
    @ApplicationContext context: Context,
) : ViewModel() {
    private lateinit var packageManager: PackageManager
    private lateinit var packageName: String
    private lateinit var lightIcon: ComponentName
    private lateinit var darkIcon: ComponentName
    val _viewState = MutableStateFlow(ZARDAppViewState.INITIAL_VALUE)
    val viewState = _viewState.asStateFlow()

    init {
        packageManager = context.packageManager
        packageName = context.packageName
        darkIcon = ComponentName(
            packageName,
            "$packageName.MainActivity_Dark"
        )
        lightIcon = ComponentName(
            packageName,
            "$packageName.MainActivity_Light"
        )
        viewModelScope.launch {
            val appSetting = AppSettingRepository().readAppSetting(context).map { Lce.Content(it) }.first()
            println(appSetting)
            val artistInformation = artistInformationRepository.getArtistInformation()
            _viewState.value = ZARDAppViewState(appSetting = appSetting, artistInformation = artistInformation)
        }
    }

    fun updateAppSetting(context: Context, appSetting: AppSetting) {
        viewModelScope.launch {
            _viewState.update {
                it.copy(appSetting = Lce.Content(appSetting))
            }
            AppSettingRepository().writeAppSetting(context, appSetting)
            changeActivityAlias(appSetting.appIconMode)
        }
    }

    private fun changeActivityAlias(appIconMode: AppIconMode) {
        if (appIconMode == AppIconMode.LIGHT_ICON) {
            packageManager.setComponentEnabledSetting(
                lightIcon,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )
            packageManager.setComponentEnabledSetting(
                darkIcon,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        } else {
            packageManager.setComponentEnabledSetting(
                darkIcon,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP
            )
            packageManager.setComponentEnabledSetting(
                lightIcon,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        }
    }

    data class ZARDAppViewState(
        val artistInformation: Lce<ArtistInformation>,
        val appSetting: Lce<AppSetting>,
    ) {
        companion object {
            val INITIAL_VALUE = ZARDAppViewState(
                artistInformation = Lce.Loading,
                appSetting = Lce.Loading,
            )
        }
    }
}
