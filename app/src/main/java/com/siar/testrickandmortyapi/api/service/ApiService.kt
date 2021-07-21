package com.siar.testrickandmortyapi.api.service

import com.siar.testrickandmortyapi.api.model.RMResponse
import retrofit2.Response
import retrofit2.http.GET



interface ApiService {

    @GET("character")
    suspend fun getAllCharacters(): Response<RMResponse>
}