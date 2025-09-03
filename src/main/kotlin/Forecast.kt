package org.yaremax

data class Forecast(
    val locationName: String,
    val maxTempC: Float,
    val minTempC: Float,
    val humidity: Int,
    val windKph: Float,
    val windDir: String
)
