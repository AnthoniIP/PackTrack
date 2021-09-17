package com.ipsoft.packtrack.data.remote.dto.correios


import com.google.gson.annotations.SerializedName

data class TrackResponseItem(
    @SerializedName("cidade")
    val cidade: String,
    @SerializedName("data")
    val `data`: String,
    @SerializedName("dataHora")
    val dataHora: String,
    @SerializedName("descricao")
    val descricao: String,
    @SerializedName("destino")
    val destino: Destino? = null,
    @SerializedName("uf")
    val uf: String
)