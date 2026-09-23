package dev.vova.chronica.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OnThisDayResponseDto(
    val events: List<HistoricalEventDto> = emptyList(),
)

@Serializable
data class HistoricalEventDto(
    val text: String,
    val year: Int? = null,
    val pages: List<WikiPageDto> = emptyList(),
)

@Serializable
data class WikiPageDto(
    val title: String? = null,
    @SerialName("normalizedtitle") val normalizedTitle: String? = null,
    val extract: String? = null,
    val lang: String? = null,
    val thumbnail: WikiImageDto? = null,
    @SerialName("originalimage") val originalImage: WikiImageDto? = null,
    @SerialName("content_urls") val contentUrls: ContentUrlsDto? = null,
)

@Serializable
data class WikiImageDto(
    val source: String,
    val width: Int? = null,
    val height: Int? = null,
)

@Serializable
data class ContentUrlsDto(
    val desktop: UrlSetDto? = null,
    val mobile: UrlSetDto? = null,
)

@Serializable
data class UrlSetDto(
    val page: String? = null,
)
