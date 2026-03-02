package dev.fbvictorhugo.pontocerto.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.fbvictorhugo.pontocerto.domain.Checkpoint
import dev.fbvictorhugo.pontocerto.utils.Calculator
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
            val current =
                currentState.checkpoint ?: Checkpoint(date = Formatters.formatDate(Date()))
            val now = Formatters.formatHour(Date())

            val updated = when {
                current.workIn.isNullOrEmpty() -> current.copy(workIn = now)

                current.lunchIn.isNullOrEmpty() -> {
                    current.copy(
                        lunchIn = now,
                        lunchOutPrev = Formatters.formatHour(Calculator.addHour(Date(), 1))
                    )
                }

                current.lunchOut.isNullOrEmpty() -> {
                    val withLunchOut = current.copy(lunchOut = now)
                    withLunchOut.copy(
                        workOutPrev = Calculator.calcTimeRemaining(withLunchOut).workOutPrev
                    )
                }

                current.workOut.isNullOrEmpty() -> current.copy(workOut = now)

                else -> current
            }
            currentState.copy(checkpoint = updated)
        }
    }
}

data class HomeUiState(
    val checkpoint: Checkpoint? = null
)
