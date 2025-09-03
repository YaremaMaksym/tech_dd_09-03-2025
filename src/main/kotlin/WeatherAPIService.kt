package org.yaremax

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("forecast.json")
    suspend fun getForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 2,
    ): WeatherForecastResponse
}