package com.example.myapplaunchweather.view.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplaunchweather.core.common.components.NormalBodyTextComponent
import com.example.myapplaunchweather.core.common.components.NormalTitleTextComponent

@Composable
fun WeatherComponent(
    modifier: Modifier = Modifier,
    weatherLabel: String,
    weatherValue: String,
    weatherUnit: String,
    iconId: Int,
) {
    ElevatedCard(
        modifier = modifier
            .padding(end = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            NormalBodyTextComponent(value = weatherLabel)

            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            NormalTitleTextComponent(value = weatherValue)

            NormalBodyTextComponent(value = weatherUnit)
        }
    }
}