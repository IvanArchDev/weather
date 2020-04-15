package com.ivtest.worldweather.network.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    private val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    private var retrofit : Retrofit? = null
    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getApiPlaceHolderApi() : ApiPlaceHolder? {
        return retrofit?.create(ApiPlaceHolder::class.java)
    }
}