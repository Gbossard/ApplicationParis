package com.example.applicationparis.data

import androidx.annotation.StringRes
import com.example.applicationparis.R

enum class MenuItemType(@StringRes val title: Int) {
    RESTAURANT(title = R.string.tab_restaurants),
    COFFEE(title = R.string.tab_coffee)
}