package com.siar.testrickandmortyapi.api

import com.siar.testrickandmortyapi.api.model.RMResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getAllCharacters(): Response<RMResponse>
}

