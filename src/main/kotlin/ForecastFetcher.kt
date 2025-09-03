package org.yaremax

private const val FORECAST_DAYS = 2
private const val TARGET_HOUR = 12

private suspend fun fetchForecast(location: String, days: Int): WeatherForecastResponse {
    return RetrofitClient.weatherAPIService.getForecast(apiKey = Config.weatherApiKey, location = location, days = days)
}

suspend fun fetchNextDayForecast(location: String): Forecast {
    val res = fetchForecast(location, FORECAST_DAYS)
    val nextDay = res.forecast.forecastday.last()
    return mapToForecast(nextDay, location)
}

private fun mapToForecast(forecastDay: ForecastDay, location: String): Forecast {
    return Forecast(
        locationName = location,
        maxTempC = forecastDay.day.maxTempC,
        minTempC = forecastDay.day.minTempC,
        humidity = forecastDay.day.avgHumidity,
        windKph = forecastDay.day.maxWindKph,
        windDir = getWindAtHour(forecastDay, TARGET_HOUR)
    )
}

private fun getWindAtHour(forecastDay: ForecastDay, targetHour: Int): String {
    val repHour = forecastDay.hour?.minByOrNull { hour ->
        val h = java.time.Instant.ofEpochSecond(hour.timeEpoch)
            .atZone(java.time.ZoneId.systemDefault())
            .hour
        kotlin.math.abs(h - targetHour)
    }

    val windDir = repHour?.windDir ?: ""

    return windDir
}
