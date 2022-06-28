package com.ipsoft.packtrack.domain.usecases

import com.ipsoft.packtrack.common.Resource
import com.ipsoft.packtrack.data.remote.dto.correios.CorreioTrackResponse
import com.ipsoft.packtrack.domain.repository.TrackRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTrackingInfoUseCase @Inject constructor(
    private val repository: TrackRepository
) {

    operator fun invoke(packTrackingCode: String): Flow<Resource<CorreioTrackResponse>> = flow {

        try {
            emit(Resource.Loading())
            val trackInfo = repository.getTrackInfo(packTrackingCode)
            emit(Resource.Success(trackInfo))

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }

    }
}