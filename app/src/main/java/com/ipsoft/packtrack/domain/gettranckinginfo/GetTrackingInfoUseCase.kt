package com.ipsoft.packtrack.domain.gettranckinginfo

import com.ipsoft.packtrack.common.Resource
import com.ipsoft.packtrack.data.remote.dto.correios.toTrackInfo
import com.ipsoft.packtrack.domain.model.TrackInfo
import com.ipsoft.packtrack.domain.repository.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetTrackingInfoUseCase @Inject constructor(
    private val repository: TrackRepository
) {

    operator fun invoke(packTrackingCode: String): Flow<Resource<TrackInfo>> = flow {

        try {
            emit(Resource.Loading())
            val trackInfo = repository.getTrackInfo(packTrackingCode).toTrackInfo()
            emit(Resource.Success(trackInfo))

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }

    }
}