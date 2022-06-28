package com.ipsoft.packtrack.presentation.packdetails

import com.ipsoft.packtrack.data.remote.dto.correios.CorreioTrackResponse

data class TrackDetailState(
    val isLoading: Boolean = false,
    val correiosResponse: CorreioTrackResponse? = null,
    val error: String = ""
)
