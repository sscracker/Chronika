package dev.vova.chronica.ui.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vova.chronica.domain.usecase.GetTodayEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodayViewModel(
    private val getTodayEvents: GetTodayEventsUseCase,
    private val lang: String = "en",
) : ViewModel() {

    private val _state = MutableStateFlow<TodayUiState>(TodayUiState.Loading)
    val state: StateFlow<TodayUiState> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        _state.value = TodayUiState.Loading
        viewModelScope.launch {
            try {
                val events = getTodayEvents(lang)

                val hero = events.firstOrNull { it.imageUrl != null } ?: events.firstOrNull()

                _state.value = if (hero == null) {
                    TodayUiState.Error("No events found for today")
                } else {
                    TodayUiState.Success(
                        event = hero,
                        more = events.filter { it != hero }.take(4),
                        lang = lang,
                    )
                }
            } catch (e: Exception) {
                _state.value = TodayUiState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}
