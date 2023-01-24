package com.example.appdedoc.api.response

import com.example.appdedoc.api.dto.DogDTO

data class DogListResponse(

    val dogs: List<DogDTO>
)