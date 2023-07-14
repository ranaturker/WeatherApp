package com.ranaturker.task1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherData  (
    val city : String,
    val degree : String,
    val degreeGap : String,
    val weatherCondition : String,
) : Parcelable