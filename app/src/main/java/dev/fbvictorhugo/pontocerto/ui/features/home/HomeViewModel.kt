package dev.fbvictorhugo.pontocerto.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.fbvictorhugo.pontocerto.domain.Checkpoint
import dev.fbvictorhugo.pontocerto.utils.Formatters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Date

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        loadCheckpoint()
    }

    private fun loadCheckpoint() {
        viewModelScope.launch {

            val today = Formatters.formatDate(Date())
            _uiState.update { it.copy(checkpoint = Checkpoint(date = today)) }
        }
    }

    fun onFabClick() {
        _uiState.update { currentState ->
            val currentCheckpoint =
                currentState.checkpoint ?: Checkpoint(date = Formatters.formatDate(Date()))
            val now = Formatters.formatHour(Date())

            val updatedCheckpoint = when {
                currentCheckpoint.workIn.isNullOrEmpty() -> currentCheckpoint.copy(workIn = now)
                currentCheckpoint.lunchIn.isNullOrEmpty() -> currentCheckpoint.copy(lunchIn = now)
                currentCheckpoint.lunchOut.isNullOrEmpty() -> currentCheckpoint.copy(lunchOut = now)
                currentCheckpoint.workOut.isNullOrEmpty() -> currentCheckpoint.copy(workOut = now)
                else -> currentCheckpoint
            }

            currentState.copy(checkpoint = updatedCheckpoint)
        }
        println("Ponto registrado!")
    }
}

data class HomeUiState(
    val checkpoint: Checkpoint? = null
)
