package com.example.applicationparis.model

import androidx.lifecycle.ViewModel
import com.example.applicationparis.data.LocalPlacesDataProvider
import com.example.applicationparis.data.MenuItemType
import com.example.applicationparis.data.Place
import com.example.applicationparis.ui.ParisUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ParisViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(ParisUiState())
    val uiState: StateFlow<ParisUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val places: Map<MenuItemType, List<Place>> =
            LocalPlacesDataProvider.allPlaces.groupBy { it.placeCategory }
        _uiState.value =
            ParisUiState(
                places = places,
                currentSelectedPlace = places[MenuItemType.RESTAURANT]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace
            )
    }

    fun updateCurrentScreen(menuItemType: MenuItemType) {
        _uiState.update {
            it.copy(
                currentScreens = menuItemType
            )
        }
    }

    fun updatesDetailsScreenStates(place: Place) {
        _uiState.update {
            it.copy(
                currentSelectedPlace = place,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedPlace = it.places[it.currentScreens]?.get(0)
                    ?: LocalPlacesDataProvider.defaultPlace,
                isShowingHomepage = true
            )
        }
    }
}