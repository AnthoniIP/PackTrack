package com.ipsoft.packtrack.data.remote.dto.correios


import com.ipsoft.packtrack.domain.model.TrackInfo
import com.ipsoft.packtrack.domain.model.TrackItem

class TrackResponse : ArrayList<TrackResponseItem>()

fun TrackResponse.toTrackInfo(): TrackInfo {


    return TrackInfo(
        this.map {
            TrackItem(
                cidade = it.cidade,
                destino = it.destino,
                dataHora = it.dataHora,
                descricao = it.descricao,
                uf = it.uf
            )
        }
    )


}


