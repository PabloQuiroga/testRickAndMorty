package com.siar.testrickandmortyapi.api.model

import com.google.gson.annotations.SerializedName

data class RMResponse(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var results: List<Personage>
)

data class Info(
    @SerializedName("count")
    var count: Int,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("next")
    var next_page: String,
    @SerializedName("prev")
    var prev_page: String?
)

data class Personage(
    @SerializedName("id")
    var id_character: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("species")
    var specie: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("origin")
    var origin: Source,
    @SerializedName("location")
    var location: Source,
    @SerializedName("image")
    var image: String,
    @SerializedName("episode")
    var episodes: List<String>,
    @SerializedName("url")
    var url: String,
    @SerializedName("created")
    var created: String
)

data class Source(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)