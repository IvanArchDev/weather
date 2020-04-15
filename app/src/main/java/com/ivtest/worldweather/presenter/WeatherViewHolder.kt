package com.ivtest.worldweather.presenter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivtest.worldweather.R
import com.ivtest.worldweather.expansion.loadPicture
import com.ivtest.worldweather.network.WeatherCity


class WeatherViewHolder(item : View) : RecyclerView.ViewHolder(item) {
    private val cityName = item.findViewById<TextView>(R.id.tv_city)
    private val temperature = item.findViewById<TextView>(R.id.tv_temperature)
    private val weatherIcon = item.findViewById<ImageView>(R.id.iv_weather_icon)

    fun bind(simple : WeatherCity){
        cityName.text = simple.name
        temperature.text = simple.main.temp.toString()
        val imageId = simple.weather[0].icon
        weatherIcon.loadPicture(imageId)
    }
}