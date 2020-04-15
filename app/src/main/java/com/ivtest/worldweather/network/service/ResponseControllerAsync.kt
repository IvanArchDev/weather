package com.ivtest.worldweather.network.service

import com.ivtest.worldweather.DataLoadListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResponseControllerAsync {

    private var listener : DataLoadListener? = null

    fun setDataLoadListener(dataLoadListener: DataLoadListener){
        listener = dataLoadListener
    }

    fun sendWeatherRequest(units : String, lat : Double, lon : Double, cnt : Int, appId : String, lang : String){
        if(listener != null){
            CoroutineScope(Dispatchers.IO).launch{
                val response = ApiResponseController().getWeatherAPI(units, lat, lon, cnt, appId, lang)
                listener?.dataLoaded(response)

            }
        } else {
            throw IllegalStateException()
        }
    }

    fun destroy(){
        listener = null
    }
}