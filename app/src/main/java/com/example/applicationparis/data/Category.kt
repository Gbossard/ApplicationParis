package com.example.applicationparis.data

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class Category(
    @StringRes val category: Int,
    @ColorRes val color: Color,
)