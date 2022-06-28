package com.ipsoft.packtrack.data.remote.dto.correios


import com.google.gson.annotations.SerializedName

data class CorreioTrackResponse(
    @SerializedName("objetos")
    val objetos: List<Objeto> = listOf(),
    @SerializedName("quantidade")
    val quantidade: Int = 0,
    @SerializedName("resultado")
    val resultado: String = "",
    @SerializedName("versao")
    val versao: String = ""
) {
    data class Objeto(
        @SerializedName("bloqueioObjeto")
        val bloqueioObjeto: Boolean = false,
        @SerializedName("codObjeto")
        val codObjeto: String = "",
        @SerializedName("dtPrevista")
        val dtPrevista: String = "",
        @SerializedName("eventos")
        val eventos: List<Evento> = listOf(),
        @SerializedName("habilitaAutoDeclaracao")
        val habilitaAutoDeclaracao: Boolean = false,
        @SerializedName("habilitaCrowdshipping")
        val habilitaCrowdshipping: Boolean = false,
        @SerializedName("habilitaLocker")
        val habilitaLocker: Boolean = false,
        @SerializedName("habilitaPercorridaCarteiro")
        val habilitaPercorridaCarteiro: Boolean = false,
        @SerializedName("modalidade")
        val modalidade: String = "",
        @SerializedName("permiteEncargoImportacao")
        val permiteEncargoImportacao: Boolean = false,
        @SerializedName("possuiLocker")
        val possuiLocker: Boolean = false,
        @SerializedName("tipoPostal")
        val tipoPostal: TipoPostal = TipoPostal()
    ) {
        data class Evento(
            @SerializedName("codigo")
            val codigo: String = "",
            @SerializedName("descricao")
            val descricao: String = "",
            @SerializedName("dtHrCriado")
            val dtHrCriado: String = "",
            @SerializedName("tipo")
            val tipo: String = "",
            @SerializedName("unidade")
            val unidade: Unidade = Unidade(),
            @SerializedName("unidadeDestino")
            val unidadeDestino: UnidadeDestino? = null,
            @SerializedName("urlIcone")
            val urlIcone: String = ""
        ) {
            data class Unidade(
                @SerializedName("endereco")
                val endereco: Endereco = Endereco(),
                @SerializedName("tipo")
                val tipo: String = ""
            ) {
                data class Endereco(
                    @SerializedName("bairro")
                    val bairro: String? = null,
                    @SerializedName("cep")
                    val cep: String? = null,
                    @SerializedName("cidade")
                    val cidade: String = "",
                    @SerializedName("complemento")
                    val complemento: String? = null,
                    @SerializedName("logradouro")
                    val logradouro: String? = null,
                    @SerializedName("numero")
                    val numero: String? = null,
                    @SerializedName("uf")
                    val uf: String = ""
                )
            }

            data class UnidadeDestino(
                @SerializedName("endereco")
                val endereco: Endereco = Endereco(),
                @SerializedName("tipo")
                val tipo: String = ""
            ) {
                data class Endereco(
                    @SerializedName("cidade")
                    val cidade: String = "",
                    @SerializedName("uf")
                    val uf: String = ""
                )
            }
        }

        data class TipoPostal(
            @SerializedName("categoria")
            val categoria: String = "",
            @SerializedName("descricao")
            val descricao: String = "",
            @SerializedName("sigla")
            val sigla: String = ""
        )
    }
}