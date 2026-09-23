package dev.vova.chronica.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Root of the Wikimedia "On this day" feed response, e.g.
 * https://api.wikimedia.org/feed/v1/wikipedia/en/onthisday/events/09/07
 *
 * The endpoint also returns other buckets (births, deaths, holidays, selected),
 * but for the "events" endpoint we only care about [events]. Any unknown field
 * is ignored by the JSON parser (ignoreUnknownKeys = true).
 */
@Serializable
data class OnThisDayResponse(
    val events: List<HistoricalEvent> = emptyList()
)

/** A single historical event tied to a calendar day. */
@Serializable
data class HistoricalEvent(
    val text: String,
    val year: Int? = null,
    val pages: List<WikiPage> = emptyList()
)

/** A linked Wikipedia article. The first page usually carries the best image/summary. */
@Serializable
data class WikiPage(
    val title: String? = null,
    @SerialName("normalizedtitle") val normalizedTitle: String? = null,
    val extract: String? = null,
    val lang: String? = null,
    val thumbnail: WikiImage? = null,
    @SerialName("originalimage") val originalImage: WikiImage? = null,
    @SerialName("content_urls") val contentUrls: ContentUrls? = null,
)

/** An image reference (thumbnail or full-size original). */
@Serializable
data class WikiImage(
    val source: String,
    val width: Int? = null,
    val height: Int? = null,
)

/** Links back to the source article, split by desktop/mobile. */
@Serializable
data class ContentUrls(
    val desktop: UrlSet? = null,
    val mobile: UrlSet? = null,
)

@Serializable
data class UrlSet(
    val page: String? = null,
)
