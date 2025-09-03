package org.yaremax

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val locations: List<String> = listOf("Chisinau", "Madrid", "Kyiv", "Amsterdam")

    val forecasts = locations.map { fetchNextDayForecast(it) }

    printForecasts(forecasts)
}

fun printForecasts(forecasts: List<Forecast>) {
    println("-----------------------------------------------------------")
    println("| Location   | Max °C | Min °C | Humidity % | Wind kph Dir |")
    println("-----------------------------------------------------------")
    for (f in forecasts) {
        println(
            "| %-10s | %6.1f | %6.1f | %10s | %3s %-7s |".format(
                f.locationName,
                f.maxTempC,
                f.minTempC,
                f.humidity,
                f.windKph,
                f.windDir
            )
        )
    }
    println("-----------------------------------------------------------")
}