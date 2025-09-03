package org.yaremax

private const val FORECAST_DAYS = 2

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
        windDir = forecastDay.hour?.first()?.windDir ?: ""
    )
}
