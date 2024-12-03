package com.example.applicationparis.ui

import com.example.applicationparis.data.LocalPlacesDataProvider
import com.example.applicationparis.data.MenuItemType
import com.example.applicationparis.data.Place

data class ParisUiState(
    val places: Map<MenuItemType, List<Place>> = emptyMap(),
    val currentScreens: MenuItemType = MenuItemType.RESTAURANT,
    val currentSelectedPlace: Place = LocalPlacesDataProvider.defaultPlace,
    val isShowingHomepage: Boolean = true
) {
    val currentPlaces: List<Place> by lazy { places[currentScreens]!! }
}