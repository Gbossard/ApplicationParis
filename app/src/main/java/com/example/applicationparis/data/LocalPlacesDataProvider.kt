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
            ),
            socialLink = R.string.place_1_social_link
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
            ),
            socialLink = R.string.place_2_social_link
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
            ),
            socialLink = R.string.place_3_social_link
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
            ),
            socialLink = R.string.place_4_social_link
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
            ),
            socialLink = R.string.place_5_social_link
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
            ),
            socialLink = R.string.place_6_social_link
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
            ),
            socialLink = R.string.place_7_social_link
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
            ),
            socialLink = R.string.place_8_social_link
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
            ),
            socialLink = R.string.place_9_social_link
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
            ),
            socialLink = R.string.place_10_social_link
        ),
        Place(
            id = 10L,
            name = R.string.place_11_name,
            description = R.string.place_11_description,
            address = R.string.place_11_address,
            photo = R.drawable.moonlight_cafe,
            placeCategory = MenuItemType.COFFEE,
            category = listOf(
                Category(
                    category = R.string.tab_coffee,
                    color = coffee_shop_color
                )
            ),
            socialLink = R.string.place_11_social_link
        ),
        Place(
            id = 11L,
            name = R.string.place_12_name,
            description = R.string.place_12_description,
            address = R.string.place_12_address,
            photo = R.drawable.booknook_cafe,
            placeCategory = MenuItemType.COFFEE,
            category = listOf(
                Category(
                    category = R.string.tab_coffee,
                    color = coffee_shop_color
                )
            ),
            socialLink = R.string.place_12_social_link
        ),
        Place(
            id = 12L,
            name = R.string.place_13_name,
            description = R.string.place_13_description,
            address = R.string.place_13_address,
            photo = R.drawable.dolci_cafe,
            placeCategory = MenuItemType.COFFEE,
            category = listOf(
                Category(
                    category = R.string.tab_coffee,
                    color = coffee_shop_color
                )
            ),
            socialLink = R.string.place_13_social_link
        ),
        Place(
            id = 13L,
            name = R.string.place_14_name,
            description = R.string.place_14_description,
            address = R.string.place_14_address,
            photo = R.drawable.cafe_mericourt,
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
            ),
            socialLink = R.string.place_14_social_link
        ),





        Place(
            id = 14L,
            name = R.string.place_15_name,
            description = R.string.place_15_description,
            address = R.string.place_15_address,
            photo = R.drawable.musee_orsay,
            placeCategory = MenuItemType.MUSEUM,
            socialLink = R.string.place_15_social_link
        ),
        Place(
            id = 15L,
            name = R.string.place_16_name,
            description = R.string.place_16_description,
            address = R.string.place_16_address,
            photo = R.drawable.musee_louvre,
            placeCategory = MenuItemType.MUSEUM,
            socialLink = R.string.place_16_social_link
        ),
        Place(
            id = 16L,
            name = R.string.place_17_name,
            description = R.string.place_17_description,
            address = R.string.place_17_address,
            photo = R.drawable.musee_orangerie,
            placeCategory = MenuItemType.MUSEUM,
            socialLink = R.string.place_17_social_link
        ),
        Place(
            id = 17L,
            name = R.string.place_18_name,
            description = R.string.place_18_description,
            address = R.string.place_18_address,
            photo = R.drawable.musee_quai_branly,
            placeCategory = MenuItemType.MUSEUM,
            socialLink = R.string.place_18_social_link
        ),



        Place(
            id = 18L,
            name = R.string.place_19_name,
            description = R.string.place_19_description,
            address = R.string.place_19_address,
            photo = R.drawable.jardin_luxembourg,
            placeCategory = MenuItemType.PARK,
            socialLink = R.string.place_19_social_link
        ),
        Place(
            id = 19L,
            name = R.string.place_20_name,
            description = R.string.place_20_description,
            address = R.string.place_20_address,
            photo = R.drawable.parc_buttes_chaumont,
            placeCategory = MenuItemType.PARK,
            socialLink = R.string.place_20_social_link
        ),
        Place(
            id = 20L,
            name = R.string.place_21_name,
            description = R.string.place_21_description,
            address = R.string.place_21_address,
            photo = R.drawable.parc_monceau,
            placeCategory = MenuItemType.PARK,
            socialLink = R.string.place_21_social_link
        ),




        Place(
            id = 21L,
            name = R.string.place_22_name,
            description = R.string.place_22_description,
            address = R.string.place_22_address,
            photo = R.drawable.galeries_lafayette,
            placeCategory = MenuItemType.SHOPPING,
            socialLink = R.string.place_22_social_link
        ),
        Place(
            id = 22L,
            name = R.string.place_23_name,
            description = R.string.place_23_description,
            address = R.string.place_23_address,
            photo = R.drawable.le_bon_marche,
            placeCategory = MenuItemType.SHOPPING,
            socialLink = R.string.place_23_social_link
        ),
        Place(
            id = 23L,
            name = R.string.place_24_name,
            description = R.string.place_24_description,
            address = R.string.place_24_address,
            photo = R.drawable.samaritaine,
            placeCategory = MenuItemType.SHOPPING,
            socialLink = R.string.place_24_social_link
        ),
        Place(
            id = 24L,
            name = R.string.place_25_name,
            description = R.string.place_25_description,
            address = R.string.place_25_address,
            photo = R.drawable.bhv,
            placeCategory = MenuItemType.SHOPPING,
            socialLink = R.string.place_25_social_link
        ),
        Place(
            id = 25L,
            name = R.string.place_26_name,
            description = R.string.place_26_description,
            address = R.string.place_26_address,
            photo = R.drawable.uniqlo,
            placeCategory = MenuItemType.SHOPPING,
            socialLink = R.string.place_26_social_link
        ),


    )

    fun get(id: Long): Place? {
        return allPlaces.firstOrNull { it.id == id }
    }

    val defaultPlace = Place(
        id = -1
    )
}