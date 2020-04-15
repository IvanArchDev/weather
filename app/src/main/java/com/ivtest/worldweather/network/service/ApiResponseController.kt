package com.ivtest.worldweather.network.service

import com.ivtest.worldweather.network.WeatherResponse

class ApiResponseController {
    private  var apiService = ApiService()

    suspend fun getWeatherAPI(units : String, lat : Double, lon : Double, cnt : Int, appId : String, lang : String): WeatherResponse? {
        return apiService.getApiPlaceHolderApi()?.getWeatherByCoordinate(units, lang, lat, lon, cnt, appId)?.body()
    }
}