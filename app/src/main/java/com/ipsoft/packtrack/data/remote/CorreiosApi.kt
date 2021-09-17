package com.ipsoft.packtrack.data.remote

import com.ipsoft.packtrack.data.remote.dto.correios.TrackResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CorreiosApi {

    @GET("rastreio/v1")
    suspend fun getTrackDetails(@Query("codigo") trackCode: String) : TrackResponse

}