package com.appsstudios.listaonlinecompartilhada.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.appsstudios.listaonlinecompartilhada.data.states.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeState("", emptyList()))
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()
    fun updateSearchString(search: String) {
        _uiState.update {
            it.copy(
                searchString = search
            )
        }
    }

}
