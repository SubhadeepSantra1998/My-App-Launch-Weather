package com.example.myapplaunchweather.view.user.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplaunchweather.core.common.components.NormalBodyTextComponent
import com.example.myapplaunchweather.core.common.components.NormalTitleTextComponent
import com.example.myapplaunchweather.data.local.User

@Composable
fun UserListItem(
    user: User,
    onItemClick: (Long) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(user.id) },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            val fullName = "${user.firstName} ${user.lastName}"
            NormalTitleTextComponent(value = fullName)

            Spacer(modifier = Modifier.height(4.dp))

            NormalBodyTextComponent(value = user.email)
        }
    }
}