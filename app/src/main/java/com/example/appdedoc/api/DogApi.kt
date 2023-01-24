package com.example.appdedoc.api


object DogApi {
    val retrofitGetDogList: Services by lazy {
        retrofit.create(Services::class.java)
    }
}
