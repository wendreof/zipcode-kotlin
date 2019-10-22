package wendreo.design.retrofit

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import wendreo.design.service.ZipCodeService

class RetrofitConfig {
    private val retrofit: Retrofit

    val cepService: ZipCodeService
        get() = this.retrofit.create(ZipCodeService::class.java)

    init {
        this.retrofit = Retrofit.Builder()
                .baseUrl("http://ws.matheuscastiglioni.com.br/ws/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
    }
}