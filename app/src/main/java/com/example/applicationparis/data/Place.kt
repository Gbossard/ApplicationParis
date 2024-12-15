package com.example.applicationparis.data

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

@SuppressLint("SupportAnnotationUsage")
data class Place(
    val id: Long,
    @StringRes val name: Int = -1,
    @StringRes val description: Int = -1,
    @StringRes val address: Int = -1,
    @DrawableRes val photo: Int = -1,
    var placeCategory: MenuItemType = MenuItemType.RESTAURANT,
    @StringRes val category: List<Category> = emptyList(),
    @StringRes val socialLink: Int = -1,
)