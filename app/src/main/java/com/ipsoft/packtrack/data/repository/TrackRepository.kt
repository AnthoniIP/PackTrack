package com.ipsoft.packtrack.data.repository

import com.ipsoft.packtrack.data.remote.CorreiosApi
import com.ipsoft.packtrack.data.remote.dto.correios.TrackResponse
import com.ipsoft.packtrack.domain.repository.TrackRepository

class TrackRepositoryImpl(
    private val api : CorreiosApi
) : TrackRepository {
    override suspend fun getTrackInfo(packTranckingCode: String): TrackResponse = api.getTrackDetails(packTranckingCode)
}