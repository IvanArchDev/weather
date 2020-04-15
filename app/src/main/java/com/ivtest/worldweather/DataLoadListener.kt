package com.ivtest.worldweather

import com.ivtest.worldweather.network.WeatherResponse

interface DataLoadListener {
    fun dataLoaded(weatherResponse: WeatherResponse?)
}