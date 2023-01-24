package com.example.appdedoc.api.response

import com.squareup.moshi.Json

data class DogList(
    val message: String,
    @field:Json(name = "is_success")
    val isSuccess: Boolean,
    val data: DogListResponse
)