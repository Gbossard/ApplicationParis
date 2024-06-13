package com.example.applicationparis.data

import com.example.applicationparis.R

object LocalPlacesDataProvider {
    val allPlaces = listOf(
        Place(
            id = 0L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 1L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 2L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 3L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 4L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 5L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 6L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 7L,
            name = R.string.place_1_name,
            description = R.string.place_1_description,
            address = R.string.place_1_address,
            photo = R.drawable.jantchi_coreen,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                R.string.category_food_asiatique,
                R.string.category_food_coreen
            )
        ),
        Place(
            id = 8L,
            name = R.string.place_2_name,
            description = R.string.place_2_description,
            address = R.string.place_2_address,
            photo = androidx.core.R.drawable.notification_tile_bg,
            placeCategory = MenuItemType.COFFEE,
        )
    )

    fun get(id: Long): Place? {
        return allPlaces.firstOrNull { it.id == id }
    }

    val defaultPlace = Place(
        id = -1
    )
}