package com.example.dbassignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieServiceImp {

    private const val BASE_URL = "http://10.0.2.2:3000"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieInterface = retrofit.create(MovieInterface::class.java)



}