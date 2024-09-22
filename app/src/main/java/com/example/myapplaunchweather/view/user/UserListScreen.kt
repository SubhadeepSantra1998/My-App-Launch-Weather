package com.example.myapplaunchweather.view.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplaunchweather.core.common.components.IconButtonComponent
import com.example.myapplaunchweather.core.common.components.NormalBodyTextComponent
import com.example.myapplaunchweather.core.common.components.SwipeToDeleteComponent
import com.example.myapplaunchweather.core.navigation.Screen
import com.example.myapplaunchweather.view.user.components.UserListItem
import com.example.myapplaunchweather.R


@Composable
fun UserListScreen(
    navController: NavController,
    viewModel: UserViewModel = hiltViewModel()
) {
    UserListScreenContent(
        navController = navController,
        viewModel = viewModel
    )
}

@Composable
private fun UserListScreenContent(
    navController: NavController,
    viewModel: UserViewModel
) {
    val state = viewModel.users.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
        ) {
            IconButtonComponent(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                icon = Icons.Default.Add,
                onClick = { navController.navigate(Screen.UserForm.route) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    state.value
                ) { user ->
                    SwipeToDeleteComponent(
                        item = user,
                        onDelete = {
                            viewModel.deleteUser(user.id)
                        }
                    ) {
                        UserListItem(
                            user = user,
                            onItemClick = {
                                navController.navigate(Screen.Weather.route)
                            }
                        )
                    }
                }
            }

            if (state.value.isEmpty()) {
                NormalBodyTextComponent(
                    modifier = Modifier.align(Alignment.Center),
                    value = stringResource(id = R.string.no_users_found)
                )
            }
        }
    }
}