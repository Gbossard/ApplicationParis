package com.example.applicationparis.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.applicationparis.R
import com.example.applicationparis.data.MenuItemType
import com.example.applicationparis.ui.ParisUiState
import com.example.applicationparis.ui.utils.ParisNavigationType

@Composable
fun ParisHomeScreen(
    navigationType: ParisNavigationType,
    parisUiState: ParisUiState,
    onTabPressed: (MenuItemType) -> Unit,
    modifier: Modifier = Modifier
) {
    val navigationItemContentList = listOf(
        NavigationItemContent(
            menuItemType = MenuItemType.RESTAURANT,
            icon = Icons.Rounded.Favorite,
            text = stringResource(id = R.string.tab_restaurants)
        ),
        NavigationItemContent(
            menuItemType = MenuItemType.COFFEE,
            icon = Icons.Rounded.AddCircle,
            text = stringResource(id = R.string.tab_coffee)
        )
    )
    ParisAppContent(
        navigationType = navigationType,
        parisUiState = parisUiState,
        onTabPressed = onTabPressed,
        navigationItemContentList = navigationItemContentList,
        modifier = modifier
    )
}

@Composable
fun ParisAppContent(
    navigationType: ParisNavigationType,
    parisUiState: ParisUiState,
    onTabPressed: (MenuItemType) -> Unit,
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
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

data class NavigationItemContent(
    val menuItemType: MenuItemType,
    val icon: ImageVector,
    val text: String
)