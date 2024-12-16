package com.example.applicationparis.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applicationparis.data.MenuItemType
import com.example.applicationparis.data.Place
import com.example.applicationparis.model.ParisViewModel
import com.example.applicationparis.ui.screens.ParisHomeScreen
import com.example.applicationparis.ui.utils.ParisNavigationType

@Composable
fun ParisApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: ParisNavigationType
    val viewModel: ParisViewModel = viewModel()
    val parisUiState = viewModel.uiState.collectAsState().value

    when(windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ParisNavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = ParisNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = ParisNavigationType.PERMANENT_NAVIGATION_DRAWER
        }
        else -> {
            navigationType = ParisNavigationType.BOTTOM_NAVIGATION
        }
    }
    ParisHomeScreen(
        navigationType = navigationType,
        parisUiState = parisUiState,
        onTabPressed = { menuItemType: MenuItemType ->
            viewModel.updateCurrentScreen(menuItemType = menuItemType)
            viewModel.resetHomeScreenStates()
        },
        onPlaceCardPressed = { place: Place ->
            viewModel.updatesDetailsScreenStates(
                place = place
            )

        },
        onDetailsScreenBackPressed = {
            viewModel.resetHomeScreenStates()
        },
        modifier = modifier
    )
}