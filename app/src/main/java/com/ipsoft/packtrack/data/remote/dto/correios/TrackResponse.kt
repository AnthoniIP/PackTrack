package com.ipsoft.packtrack.data.remote.dto.correios


import com.ipsoft.packtrack.domain.model.TrackInfo

class TrackResponse : ArrayList<TrackResponseItem>()

fun TrackResponse.toTrackInfo(): TrackInfo = TrackInfo(
    this
)