package com.ipsoft.packtrack.domain.repository

import com.ipsoft.packtrack.data.remote.dto.correios.TrackResponse

interface TrackRepository {

    suspend fun getTrackInfo(packTranckingCode: String) : TrackResponse

}