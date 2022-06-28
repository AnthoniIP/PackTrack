package com.ipsoft.packtrack.presentation.pack_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsoft.packtrack.common.Constants
import com.ipsoft.packtrack.common.Resource
import com.ipsoft.packtrack.domain.gettranckinginfo.GetTrackingInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class PackDetailViewModel @Inject constructor(
    private val getTrackingInfoUseCase: GetTrackingInfoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _trackDetails = mutableStateOf(TrackDetailState())
    val trackDetails: State<TrackDetailState> = _trackDetails

    init {
        savedStateHandle.get<String>(Constants.PARAM_PACK_TRACK_CODE)?.let { trackCode ->
            getTrack(trackCode)
        }
    }

    private fun getTrack(trackCode: String) = getTrackingInfoUseCase(trackCode).onEach { result ->

        when (result) {
            is Resource.Success -> {
                _trackDetails.value = TrackDetailState(track = result.data)
            }
            is Resource.Error -> {
                _trackDetails.value = TrackDetailState(
                    error = result.message ?: "An unexpected error occured"
                )
            }
            is Resource.Loading -> {
                _trackDetails.value = TrackDetailState(isLoading = true)
            }
        }
    }.launchIn(viewModelScope)

}

