package com.ipsoft.packtrack.domain.model

import com.google.gson.annotations.SerializedName
import com.ipsoft.packtrack.data.remote.dto.correios.Destino

data class TrackItem(
    @SerializedName("cidade")
    val cidade: String,
    @SerializedName("dataHora")
    val dataHora: String,
    @SerializedName("descricao")
    val descricao: String,
    @SerializedName("destino")
    val destino: Destino? = null,
    @SerializedName("uf")
    val uf: String
)
