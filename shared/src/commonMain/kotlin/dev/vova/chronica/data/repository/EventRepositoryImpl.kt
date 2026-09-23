package dev.vova.chronica.data.repository

import dev.vova.chronica.data.mapper.toDomain
import dev.vova.chronica.data.remote.OnThisDayApi
import dev.vova.chronica.domain.model.Event
import dev.vova.chronica.domain.repository.EventRepository

class EventRepositoryImpl(
    private val api: OnThisDayApi,
) : EventRepository {

    override suspend fun getEventsForDay(lang: String, month: Int, day: Int): List<Event> =
        api.getEvents(lang = lang, month = month, day = day)
            .map { it.toDomain() }
}
