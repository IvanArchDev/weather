package com.ivtest.worldweather.network.service

import com.ivtest.worldweather.network.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPlaceHolder {
    @GET("find")
    suspend fun getWeatherByCoordinate( @Query("units") units : String,
                                       @Query("lang") lang : String,
                                       @Query("lat")lat : Double,
                                       @Query("lon") lon : Double,
                                       @Query("cnt") cnt : Int,
                                       @Query("appid") appId : String
    ) : Response<WeatherResponse>
}