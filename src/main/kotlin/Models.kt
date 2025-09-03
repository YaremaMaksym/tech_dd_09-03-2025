package org.yaremax

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherForecastResponse(
    val location: Location,
    val forecast: ForecastBlock
)

@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    @Json(name = "tz_id") val tzId: String
)

@JsonClass(generateAdapter = true)
data class ForecastBlock(
    val forecastday: List<ForecastDay>
)

@JsonClass(generateAdapter = true)
data class ForecastDay(
    val date: String,
    val day: DaySummary,
    val hour: List<Hour>?
)

@JsonClass(generateAdapter = true)
data class DaySummary(
    @Json(name = "maxtemp_c") val maxTempC: Float,
    @Json(name = "mintemp_c") val minTempC: Float,
    @Json(name = "avghumidity") val avgHumidity: Int,
    @Json(name = "maxwind_kph") val maxWindKph: Float
)

@JsonClass(generateAdapter = true)
data class Hour(
    @Json(name = "time_epoch") val timeEpoch: Long,
    @Json(name = "wind_dir") val windDir: String?
)
