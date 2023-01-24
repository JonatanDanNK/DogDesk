package com.example.appdedoc.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

    val retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .addConverterFactory(MoshiConverterFactory.create())
     .build()