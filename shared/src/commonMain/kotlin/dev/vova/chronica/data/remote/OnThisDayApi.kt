package dev.vova.chronica.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val USER_AGENT = "ChronicaApp/0.1 (https://github.com/sscracker/Chronika)"

class OnThisDayApi(
    private val client: HttpClient = defaultHttpClient(),
) {

    suspend fun getEvents(lang: String, month: Int, day: Int): List<HistoricalEvent> {
        val mm = month.toString().padStart(2, '0')
        val dd = day.toString().padStart(2, '0')
        val url = "$BASE_URL/feed/v1/wikipedia/$lang/onthisday/events/$mm/$dd"
        return client.get(url).body<OnThisDayResponse>().events
    }

    companion object {
        private const val BASE_URL = "https://api.wikimedia.org"
    }
}

private fun defaultHttpClient(): HttpClient = HttpClient {
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    defaultRequest {
        header(HttpHeaders.UserAgent, USER_AGENT)
    }
}
