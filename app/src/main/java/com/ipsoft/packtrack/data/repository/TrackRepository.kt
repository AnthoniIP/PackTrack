package com.ipsoft.packtrack.data.repository

import com.ipsoft.packtrack.data.remote.dto.correios.TrackResponse
import com.ipsoft.packtrack.data.remote.dto.correios.TrackService
import com.ipsoft.packtrack.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val service: TrackService,
) : TrackRepository {
    override suspend fun getTrackInfo(packTranckingCode: String): TrackResponse =
        service.getTrackDetails(packTranckingCode)
}