package com.jung.compose101.screen.week3

import androidx.lifecycle.ViewModel
import com.jung.compose101.screen.week3.contract.Week3Event
import com.jung.compose101.screen.week3.contract.Week3State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Week3ViewModel : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<Week3State> = MutableStateFlow(Week3State())
    val uiStateFlow: StateFlow<Week3State> = _uiStateFlow.asStateFlow()

    fun handleEvent(e: Week3Event) {
        when (e) {
            is Week3Event.DeleteItem -> {
                _uiStateFlow.update { state ->
                    val newList = state.events.toMutableList().apply { removeIf { it.id == e.id } }
                    state.copy(events = newList)
                }
            }
        }
    }
}