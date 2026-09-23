package dev.vova.chronica.domain.usecase

import dev.vova.chronica.domain.model.Event
import dev.vova.chronica.domain.repository.EventRepository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class GetTodayEventsUseCase(
    private val repository: EventRepository,
) {
    @OptIn(ExperimentalTime::class)
    suspend operator fun invoke(lang: String): List<Event> {
        val iso = Clock.System.todayIn(TimeZone.currentSystemDefault()).toString()
        val (_, month, day) = iso.split("-")
        return repository.getEventsForDay(lang = lang, month = month.toInt(), day = day.toInt())
    }
}
