package com.ipsoft.packtrack.presentation.pack_detail

import com.ipsoft.packtrack.domain.model.TrackInfo

data class TrackDetailState(
    val isLoading: Boolean = false,
    val track: TrackInfo? = null,
    val error: String = ""
)
