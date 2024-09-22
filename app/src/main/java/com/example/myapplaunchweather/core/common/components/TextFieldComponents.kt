package com.example.myapplaunchweather.core.common.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextFieldComponent(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onTextChanged(it)
        },
        label = { Text(text = label) },
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions.Default,
        isError = !errorStatus
    )
}