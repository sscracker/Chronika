package dev.vova.chronica.ui.today

import dev.vova.chronica.domain.model.Event

sealed interface TodayUiState {

    data object Loading : TodayUiState

    data class Success(
        val event: Event,
        val more: List<Event>,
        val lang: String,
    ) : TodayUiState

    data class Error(val message: String) : TodayUiState
}
