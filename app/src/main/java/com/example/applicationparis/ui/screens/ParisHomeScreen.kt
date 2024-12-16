package com.example.applicationparis.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
    if (navigationType == ParisNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(Modifier.width(240.dp)) {
                    NavigationDrawerContent(
                        selectedDestination = parisUiState.currentScreens,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                    )
                }
            }
        ) {
            ParisAppContent(
                navigationType = navigationType,
                parisUiState = parisUiState,
                onTabPressed = onTabPressed,
                onPlaceCardPressed = onPlaceCardPressed,
                navigationItemContentList = navigationItemContentList
            )
        }
    } else {
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
            AnimatedVisibility(visible = navigationType == ParisNavigationType.NAVIGATION_RAIL) {
                ParisNavigationRail(
                    currentTab = parisUiState.currentScreens,
                    onTabPressed = onTabPressed,
                    navigationItemContentList = navigationItemContentList
                )
            }
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
private fun ParisNavigationRail(
    currentTab: MenuItemType,
    onTabPressed: ((MenuItemType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
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

@Composable
private fun NavigationDrawerContent(
    selectedDestination: MenuItemType,
    onTabPressed: ((MenuItemType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = {
                    Text(
                        text = navItem.text,
                    )
                },
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                selected = selectedDestination == navItem.menuItemType,
                onClick = { onTabPressed(navItem.menuItemType) }
            )
        }
    }
}

@Composable
private fun NavigationDrawerHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ParisLogo(modifier = Modifier.size(48.dp))

    }
}

@Composable
fun ParisLogo(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.logo),
        colorFilter = ColorFilter.tint(color),
        modifier = modifier
    )
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