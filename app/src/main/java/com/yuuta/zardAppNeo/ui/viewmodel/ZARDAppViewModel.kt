package com.yuuta.zardAppNeo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.yuuta.common.model.ArtistInformation
import com.yuuta.common.model.Lce
import com.yuuta.zardAppNeo.data.repository.ArtistInformationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ZARDAppViewModel @Inject constructor(
    artistInformationRepository: ArtistInformationRepository
) : ViewModel(){
    val _viewState = MutableStateFlow(ZARDAppViewState.INITIAL_VALUE)
    val viewState = _viewState.asStateFlow()

    init {
        _viewState.value = ZARDAppViewState(artistInformationRepository.getArtistInformation())
    }

    data class ZARDAppViewState(
        val artistInformation: Lce<ArtistInformation>
    ) {
        companion object {
            val INITIAL_VALUE = ZARDAppViewState(Lce.Loading)
        }
    }
}
