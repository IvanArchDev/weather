package com.ivtest.worldweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivtest.worldweather.adapter.WeatherAdapter
import com.ivtest.worldweather.network.WeatherResponse
import com.ivtest.worldweather.network.service.ResponseControllerAsync
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, DataLoadListener {

    private val controllerAsync = ResponseControllerAsync()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_get_data.setOnClickListener(this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_weather)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WeatherAdapter()
        controllerAsync.setDataLoadListener(this)

    }

    override fun onClick(v: View?) {
        val latitude = et_latitude.text.toString().toDouble()
        val longitude = et_longitude.text.toString().toDouble()
        sendRequest(latitude, longitude)
    }

    override fun dataLoaded(weatherResponse: WeatherResponse?) {
        runOnUiThread {
            if(weatherResponse != null && !weatherResponse.list.isNullOrEmpty()){
                (rv_weather.adapter as WeatherAdapter).setData(weatherResponse.list)
                (rv_weather.adapter as WeatherAdapter).notifyDataSetChanged()
                title_main_screen.visibility = View.GONE
            } else {
                (rv_weather.adapter as WeatherAdapter).clearData()
                (rv_weather.adapter as WeatherAdapter).notifyDataSetChanged()
                title_main_screen.text = getString(R.string.nothing_found)
                title_main_screen.visibility = View.VISIBLE
            }
        }
    }

    private fun sendRequest(latitude : Double, longitude : Double){
        val count = 20
        controllerAsync.sendWeatherRequest(UNITS, latitude, longitude, count, API_KEY, LANG)
    }

    override fun onDestroy() {
        super.onDestroy()
        controllerAsync.destroy()
    }
}
