package com.ivtest.worldweather.network


data class WeatherResponse (
    val message : String,
    val cod : Int,
    val count : Int,
    val list : List<WeatherCity>
)

data class Clouds (
    val all : Int
)

data class Coord (
    val lat : Double,
    val lon : Double
)

data class WeatherCity (
    val id : Int,
    val name : String,
    val coord : Coord,
    val main : TemperatureIndicators,
    val dt : Int,
    val wind : Wind,
    val sys : Sys,
    val rain : String,
    val snow : String,
    val clouds : Clouds,
    val weather : List<Weather>
)

data class TemperatureIndicators (
    val temp : Double,
    val pressure : Int,
    val humidity : Int,
    val temp_min : Double,
    val temp_max : Double
)

data class Sys (
    val country : String
)

data class Weather (
    val id : Int,
    val main : String,
    val description : String,
    val icon : String
)

data class Wind (
    val speed : Double,
    val deg : Int,
    val gust : Int
)