package dev.vova.chronica.domain.model
data class Event(
    val year: Int?,
    val text: String,
    val title: String?,
    val summary: String?,
    val imageUrl: String?,
    val sourceUrl: String?,
)
