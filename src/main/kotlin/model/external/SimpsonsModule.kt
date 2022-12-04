package model.external

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object SimpsonsModule {
    private const val BASE_URL = "https://thesimpsonsquoteapi.glitch.me/"
    private val retrofitAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val simpsonsAPI = retrofitAPI.create(SimpsonsAPI::class.java)
    private val simpsonsToQuoteResolver = JsonToQuoteResolver()

    val simpsonsService : SimpsonsService = SimpsonsServiceImpl(simpsonsAPI, simpsonsToQuoteResolver)
}