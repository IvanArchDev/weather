package com.ivtest.worldweather.expansion

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ivtest.worldweather.R

fun ImageView.loadPicture(imageId : String){
    val url = "http://openweathermap.org/img/wn/$imageId.png"
    val options: RequestOptions = RequestOptions()
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher_round)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this).load(url).apply(options).into(this)
}