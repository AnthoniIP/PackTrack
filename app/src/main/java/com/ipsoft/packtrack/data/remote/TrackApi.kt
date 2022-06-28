package com.ipsoft.packtrack.data.remote

import com.ipsoft.packtrack.data.remote.dto.correios.CorreioTrackResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TrackApi {

    @GET("v1/sro-rastro/{code}")
    suspend fun getTrackDetails(@Path("code") trackCode: String): CorreioTrackResponse

}