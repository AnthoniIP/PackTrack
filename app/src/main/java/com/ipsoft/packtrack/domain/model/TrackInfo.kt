package com.ipsoft.packtrack.domain.model

import com.ipsoft.packtrack.data.remote.dto.correios.TrackResponseItem

data class TrackInfo(
    val trackItemList: ArrayList<TrackResponseItem>
)
