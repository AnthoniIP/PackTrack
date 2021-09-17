package com.ipsoft.packtrack.data.remote.dto.correios


import com.ipsoft.packtrack.domain.model.TrackInfo

data class TrackResponse(
    val trackItemList: ArrayList<TrackResponseItem>
)

fun TrackResponse.toTrackInfo(): TrackInfo = TrackInfo(
    this.trackItemList
)

