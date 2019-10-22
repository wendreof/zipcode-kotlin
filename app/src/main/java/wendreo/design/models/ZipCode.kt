package wendreo.design.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("codibge", "codestado")
class ZipCode {

    var cep: String? = null
    var logradouro: String? = null
    var complemento: String? = null
    var bairro: String? = null
    var cidade: String? = null
    var estado: String? = null

    override fun toString(): String {
        return ("CEP: " + cep
                + "\nLogradouro: " + logradouro
                + "\nComplemento: " + complemento
                + "\nBairro: " + bairro
                + "\nCidade:" + cidade
                + "\nEstado: " + estado)
    }
}