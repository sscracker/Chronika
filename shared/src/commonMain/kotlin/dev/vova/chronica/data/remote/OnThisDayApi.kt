package dev.vova.chronica.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class OnThisDayApi(
    private val client: HttpClient,
) {

    suspend fun getEvents(lang: String, month: Int, day: Int): List<HistoricalEventDto> {
        val mm = month.toString().padStart(2, '0')
        val dd = day.toString().padStart(2, '0')
        val url = "$BASE_URL/feed/v1/wikipedia/$lang/onthisday/events/$mm/$dd"
        return client.get(url).body<OnThisDayResponseDto>().events
    }

    companion object {
        private const val BASE_URL = "https://api.wikimedia.org"
    }
}
