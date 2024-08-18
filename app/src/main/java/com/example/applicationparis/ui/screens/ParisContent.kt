package com.example.applicationparis.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applicationparis.R
import com.example.applicationparis.data.Place
import com.example.applicationparis.ui.ParisUiState

@Composable
fun ParisListOnlyContent(
    parisUiState: ParisUiState,
    modifier: Modifier = Modifier
) {
    val places = parisUiState.currentPlaces
    val categoryTitle = parisUiState.currentScreens.title

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.email_list_item_vertical_spacing)
        )
    ) {
        item {
            ParisTitleContent(
                placeTitle = categoryTitle,
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(places, key = { place -> place.id }) { place ->
            Column(modifier = Modifier.fillMaxWidth()) {
                ParisListItem(
                    place = place,
                    selected = true
                )
            }

        }
    }
}

@Composable
fun ParisTitleContent(
    placeTitle: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = stringResource(placeTitle),
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParisListItem(
    place: Place,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            }
        ),
        onClick = { /*TODO*/ }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column{
                Image(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(place.photo),
                    contentDescription = "",
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp, bottom = 0.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(place.name),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W600,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(place.address),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W300,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    place.category.forEach {
                        Text(
                            text = stringResource(it.category),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W200,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .alpha(1f)
                                .background(color = it.color)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

            }
        }
    }
}