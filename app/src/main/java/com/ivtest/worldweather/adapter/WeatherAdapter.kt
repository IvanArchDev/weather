package com.ivtest.worldweather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivtest.worldweather.R
import com.ivtest.worldweather.network.WeatherCity
import com.ivtest.worldweather.presenter.WeatherViewHolder

class WeatherAdapter : RecyclerView.Adapter<WeatherViewHolder>() {
    private val list = mutableListOf<WeatherCity>()

    fun setData(loadedData : List<WeatherCity>){
        list.clear()
        list.addAll(loadedData)
    }

    fun clearData(){
        list.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_card, parent, false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnLongClickListener{
            list.remove(list[position])
        }
    }
}