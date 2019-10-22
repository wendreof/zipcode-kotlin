package wendreo.design.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import wendreo.design.models.ZipCode

interface ZipCodeService {
    @GET("cep/find/{cep}/json")
    fun buscarCEP(@Path("cep") cep: String): Call<ZipCode>
}