package com.example.applicationparis.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.applicationparis.R
import com.example.applicationparis.data.Place
import com.example.applicationparis.ui.ParisUiState

@Composable
fun ParisDetailsScreen(
    parisUiState: ParisUiState,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = false
) {
    BackHandler {
        onBackPressed()
    }
    Box(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            item {
                if (isFullScreen) {
                    ParisDetailsScreenTopBar(
                        onBackPressed,
                        parisUiState,
                        Modifier
                            .fillMaxWidth()
                    )
                }
                ParisDetailsCard(
                    place = parisUiState.currentSelectedPlace,
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }
}

@Composable
fun ParisDetailsScreenTopBar(
    onBackButtonPressed: () -> Unit,
    parisUiState: ParisUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(
            horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal),
            vertical = dimensionResource(R.dimen.detail_topbar_back_button_padding_vertical)
        ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onBackButtonPressed,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                contentDescription = stringResource(id = R.string.navigation_back)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = dimensionResource(R.dimen.detail_place_padding_end))
        ) {
            Text(
                text = stringResource(parisUiState.currentSelectedPlace.name),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun ParisDetailsCard(
    place: Place,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(place.photo),
                contentDescription = null
            )
        }
        Column(
            modifier = modifier
                .padding(dimensionResource(R.dimen.detail_card_inner_padding))
        ) {
            Text(
                text = stringResource(place.name),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = stringResource(place.address),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                modifier = Modifier
                    .padding(vertical = 24.dp),
                text = stringResource(place.description),
                style = MaterialTheme.typography.bodyLarge
            )
            ButtonToSocialMedia(stringResource(place.socialLink))
        }

    }
}

@Composable
fun ButtonToSocialMedia(
    socialLink: String
) {
    val context = LocalContext.current
    val webIntent: Intent = Uri.parse(socialLink).let { webpage ->
        Intent(Intent.ACTION_VIEW, webpage)
    }
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { context.startActivity(webIntent) }
    ) {
        Text(
            text = stringResource(R.string.social_link),
        )
    }
}