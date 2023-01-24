package com.example.appdedoc.api

import com.example.appdedoc.api.response.DogList
import retrofit2.http.GET

interface Services {
    @GET("dogs")
    suspend fun getListDogs(): DogList
}