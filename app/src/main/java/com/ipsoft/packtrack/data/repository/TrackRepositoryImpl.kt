package com.ipsoft.packtrack.data.repository

import com.ipsoft.packtrack.data.remote.TrackService
import com.ipsoft.packtrack.data.remote.dto.correios.CorreioTrackResponse
import com.ipsoft.packtrack.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val service: TrackService,
) : TrackRepository {
    override suspend fun getTrackInfo(packTranckingCode: String): CorreioTrackResponse =
        service.getTrackDetails(packTranckingCode)
}