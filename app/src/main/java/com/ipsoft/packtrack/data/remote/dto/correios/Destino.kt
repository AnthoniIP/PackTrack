package com.ipsoft.packtrack.data.remote.dto.correios


import com.google.gson.annotations.SerializedName

data class Destino(
    @SerializedName("cidade")
    val cidade: String,
    @SerializedName("uf")
    val uf: String
)