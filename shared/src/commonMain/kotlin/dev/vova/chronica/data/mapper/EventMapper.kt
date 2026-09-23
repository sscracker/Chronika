package dev.vova.chronica.data.mapper

import dev.vova.chronica.data.remote.HistoricalEventDto
import dev.vova.chronica.domain.model.Event

fun HistoricalEventDto.toDomain(): Event {
    val page = pages.firstOrNull()
    return Event(
        year = year,
        text = text.cleanWikiText(),
        title = page?.normalizedTitle ?: page?.title,
        summary = page?.extract?.cleanWikiText(),
        imageUrl = page?.originalImage?.source ?: page?.thumbnail?.source,
        sourceUrl = page?.contentUrls?.desktop?.page,
    )
}

private fun String.cleanWikiText(): String =
    replace(EDITORIAL_MARKER, "")
        .replace(MULTIPLE_SPACES, " ")
        .trim()

private val EDITORIAL_MARKER = Regex("\\[[^\\]]*\\?]")
private val MULTIPLE_SPACES = Regex("\\s{2,}")
