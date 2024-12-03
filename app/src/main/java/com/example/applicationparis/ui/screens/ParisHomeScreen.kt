package com.example.applicationparis.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.applicationparis.R
import com.example.applicationparis.data.MenuItemType
import com.example.applicationparis.data.Place
import com.example.applicationparis.ui.ParisUiState
import com.example.applicationparis.ui.utils.ParisNavigationType

@Composable
fun ParisHomeScreen(
    navigationType: ParisNavigationType,
    parisUiState: ParisUiState,
    onTabPressed: (MenuItemType) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    onDetailsScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            menuItemType = MenuItemType.RESTAURANT,
            icon = painterResource(R.drawable.local_dining_24dp),
            text = stringResource(id = R.string.tab_restaurants)
        ),
        NavigationItemContent(
            menuItemType = MenuItemType.COFFEE,
            icon = painterResource(R.drawable.local_cafe_24dp),
            text = stringResource(id = R.string.tab_coffee)
        )
    )
    if (parisUiState.isShowingHomepage) {
        ParisAppContent(
            navigationType = navigationType,
            parisUiState = parisUiState,
            onTabPressed = onTabPressed,
            onPlaceCardPressed = onPlaceCardPressed,
            navigationItemContentList = navigationItemContentList,
            modifier = modifier
        )
    } else {
        ParisDetailsScreen(
            parisUiState = parisUiState,
            onBackPressed = onDetailsScreenBackPressed,
            modifier = modifier,
            isFullScreen = true
        )
    }
}

@Composable
fun ParisAppContent(
    navigationType: ParisNavigationType,
    parisUiState: ParisUiState,
    onTabPressed: (MenuItemType) -> Unit,
    onPlaceCardPressed: (Place) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            ) {
                    ParisListOnlyContent(
                        parisUiState = parisUiState,
                        onPlaceCardPressed = onPlaceCardPressed,
                        modifier = Modifier.weight(1f)
                    )
                AnimatedVisibility(
                    visible = navigationType == ParisNavigationType.BOTTOM_NAVIGATION
                ) {
                    ParisBottomAppBar(
                        currentTab = parisUiState.currentScreens,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ParisBottomAppBar(
    currentTab: MenuItemType,
    onTabPressed: ((MenuItemType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.menuItemType,
                onClick = { onTabPressed(navItem.menuItemType) },
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

data class NavigationItemContent(
    val menuItemType: MenuItemType,
    val icon: Painter,
    val text: String
)