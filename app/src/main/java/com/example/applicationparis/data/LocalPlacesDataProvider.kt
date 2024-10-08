package com.example.applicationparis.data

import com.example.applicationparis.R
import com.example.applicationparis.ui.theme.asian_color
import com.example.applicationparis.ui.theme.balinese_color
import com.example.applicationparis.ui.theme.brunch_color
import com.example.applicationparis.ui.theme.coffee_shop_color
import com.example.applicationparis.ui.theme.coreen_color
import com.example.applicationparis.ui.theme.hawaiian_color
import com.example.applicationparis.ui.theme.italian_color
import com.example.applicationparis.ui.theme.japanese_color
import com.example.applicationparis.ui.theme.mexican_color


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
                Category(
                    category = R.string.category_food_asian,
                    color = asian_color
                ),

                Category(
                    category = R.string.category_food_korean,
                    color = coreen_color
                )
            )
        ),
        Place(
            id = 1L,
            name = R.string.place_2_name,
            description = R.string.place_2_description,
            address = R.string.place_2_address,
            photo = R.drawable.pinkmamma_italien,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_italian,
                    color = italian_color
                )
            )
        ),
        Place(
            id = 2L,
            name = R.string.place_3_name,
            description = R.string.place_3_description,
            address = R.string.place_3_address,
            photo = R.drawable.mammaprimi_italien,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_italian,
                    color = italian_color
                )
            )
        ),
        Place(
            id = 3L,
            name = R.string.place_4_name,
            description = R.string.place_4_description,
            address = R.string.place_4_address,
            photo = R.drawable.tigermilk_mexican,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_mexican,
                    color = mexican_color
                )
            )
        ),
        Place(
            id = 4L,
            name = R.string.place_5_name,
            description = R.string.place_5_description,
            address = R.string.place_5_address,
            photo = R.drawable.karaageya_japanese,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_asian,
                    color = asian_color
                ),
                Category(
                    category = R.string.category_food_japanese,
                    color = japanese_color
                )
            )
        ),
        Place(
            id = 5L,
            name = R.string.place_6_name,
            description = R.string.place_6_description,
            address = R.string.place_6_address,
            photo = R.drawable.hawaiian_poke_hawaian,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_hawaiian,
                    color = hawaiian_color
                )
            )
        ),
        Place(
            id = 6L,
            name = R.string.place_7_name,
            description = R.string.place_7_description,
            address = R.string.place_7_address,
            photo = R.drawable.djakarta_bali_balinais,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_asian,
                    color = asian_color
                ),
                Category(
                    category = R.string.category_food_balinese,
                    color = balinese_color
                )
            )
        ),
        Place(
            id = 7L,
            name = R.string.place_8_name,
            description = R.string.place_8_description,
            address = R.string.place_8_address,
            photo = R.drawable.kodawari_ramen_japanese,
            placeCategory = MenuItemType.RESTAURANT,
            category = listOf(
                Category(
                    category = R.string.category_food_asian,
                    color = asian_color
                ),

                Category(
                    category = R.string.category_food_japanese,
                    color = japanese_color
                )
            )
        ),





        Place(
            id = 8L,
            name = R.string.place_9_name,
            description = R.string.place_9_description,
            address = R.string.place_9_address,
            photo = R.drawable.annettek_coffee_shop,
            placeCategory = MenuItemType.COFFEE,
            category = listOf(
                Category(
                    category = R.string.tab_coffee,
                    color = coffee_shop_color
                )
            )
        ),
        Place(
            id = 9L,
            name = R.string.place_10_name,
            description = R.string.place_10_description,
            address = R.string.place_10_address,
            photo = R.drawable.o_coffee,
            placeCategory = MenuItemType.COFFEE,
            category = listOf(
                Category(
                    category = R.string.tab_coffee,
                    color = coffee_shop_color
                ),
                Category(
                    category = R.string.category_food_brunch,
                    color = brunch_color
                )
            )
        )
    )

    fun get(id: Long): Place? {
        return allPlaces.firstOrNull { it.id == id }
    }

    val defaultPlace = Place(
        id = -1
    )
}