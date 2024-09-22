package com.example.myapplaunchweather.core.common.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NormalBodyTextComponent(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = value,
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall
    )
}

@Composable
fun NormalTitleTextComponent(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = value,
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun NormalHeadingTextComponent(
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = value,
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}