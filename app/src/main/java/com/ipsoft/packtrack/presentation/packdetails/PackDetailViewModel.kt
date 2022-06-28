package com.ipsoft.packtrack.presentation.packdetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsoft.packtrack.common.Constants
import com.ipsoft.packtrack.common.Resource
import com.ipsoft.packtrack.domain.usecases.GetTrackingInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class PackDetailViewModel @Inject constructor(
    private val getTrackingInfoUseCase: GetTrackingInfoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(TrackDetailState())
    val state: State<TrackDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PACK_TRACK_CODE)?.let { trackCode ->
            getTrack(trackCode)
        }
    }

    private fun getTrack(trackCode: String) = getTrackingInfoUseCase(trackCode).onEach { result ->

        when (result) {
            is Resource.Success -> {
                _state.value = TrackDetailState(correiosResponse = result.data)
            }
            is Resource.Error -> {
                _state.value = TrackDetailState(
                    error = result.message ?: "An unexpected error occured"
                )
            }
            is Resource.Loading -> {
                _state.value = TrackDetailState(isLoading = true)
            }
        }
    }.launchIn(viewModelScope)

}

