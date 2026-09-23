package dev.vova.chronica.domain.repository

import dev.vova.chronica.domain.model.Event

interface EventRepository {
    suspend fun getEventsForDay(lang: String, month: Int, day: Int): List<Event>
}
