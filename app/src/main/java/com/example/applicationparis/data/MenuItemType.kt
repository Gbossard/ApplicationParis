package com.example.applicationparis.data

import androidx.annotation.StringRes
import com.example.applicationparis.R

enum class MenuItemType(@StringRes val title: Int) {
    RESTAURANT(title = R.string.tab_restaurants),
    COFFEE(title = R.string.tab_coffee),
    MUSEUM(title = R.string.tab_museum),
    PARK(title = R.string.tab_park),
    SHOPPING(title = R.string.tab_shopping)
}