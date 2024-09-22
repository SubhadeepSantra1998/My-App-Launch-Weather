package com.example.myapplaunchweather.core.common.components

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplaunchweather.R

@Composable
fun BackButtonComponent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Button(
        onClick = { onBackClick() },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = stringResource(id = R.string.back),
        )
    }
}

@Composable
fun IconButtonComponent(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(id = R.string.icon),
        )
    }
}

@Composable
fun TextButtonComponent(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .heightIn(48.dp),
        enabled = isEnabled
    ) {
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}