package org.yaremax

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val locations: List<String> = listOf("Chisinau", "Madrid", "Kyiv", "Amsterdam")

    val forecasts = locations.map { fetchNextDayForecast(it) }

    printForecasts(forecasts)
}

fun printForecasts(forecasts: List<Forecast>) {
    println("-------------------------------------------------------------------------")
    println("| Location   | Max °C | Min °C | Humidity | Wind Speed | Wind Direction |")
    println("-------------------------------------------------------------------------")
    for (f in forecasts) {
        val humidityStr = "${f.humidity}%"
        val windKphStr = "${f.windKph} kph"
        println(
            "| %-10s | %6.1f | %6.1f | %8s | %10s | %14s |".format(
                f.locationName,
                f.maxTempC,
                f.minTempC,
                humidityStr,
                windKphStr,
                f.windDir
            )
        )
    }
    println("-------------------------------------------------------------------------")
}