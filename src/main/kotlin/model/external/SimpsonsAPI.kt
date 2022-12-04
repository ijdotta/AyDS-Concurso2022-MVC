package model.external

import retrofit2.Call
import retrofit2.http.GET

internal interface SimpsonsAPI {

    @GET("quotes")
    fun getRandomQuote() : Call<String>
}