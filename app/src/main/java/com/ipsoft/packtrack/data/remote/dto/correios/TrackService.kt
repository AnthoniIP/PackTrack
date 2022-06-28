package com.ipsoft.packtrack.data.remote.dto.correios

import com.ipsoft.packtrack.data.remote.TrackApi
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Retrofit

@Singleton
class TrackService
@Inject constructor(retrofit: Retrofit) : TrackApi {

    private val api by lazy { retrofit.create(TrackApi::class.java) }

    override suspend fun getTrackDetails(trackCode: String): TrackResponse =
        api.getTrackDetails(trackCode)


}