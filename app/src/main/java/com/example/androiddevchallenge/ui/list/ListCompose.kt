/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.domain.Amigo
import com.example.androiddevchallenge.ui.util.Chip

@Composable
fun puppyList(state: ListState, navController: NavHostController) {
    Surface(color = Color(0xFFC3C3C3)) {
        Scaffold(
            topBar = { topBarSearch() },
            content = { contentList(state = state, navController) }
        )
    }
}

@Composable
fun contentList(state: ListState, navController: NavHostController) {
    when (state) {
        is ListState.Error -> {
        }
        is ListState.Loading -> {
            CircularProgressIndicator()
        }
        is ListState.Data -> {
            LazyColumn() {
                items(state.data) { cell ->
                    amigoCell(amigo = cell, navController)
                }
            }
        }
    }
}

@Composable
fun topBarSearch() {
    TopAppBar(
        title = {
            Text(
                text = "Find a good doggo!"
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Rounded.MenuBook, "")
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
        elevation = 1.dp
    )
}

@Composable
fun amigoCell(amigo: Amigo, navController: NavHostController) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth()
            .clickable { navController.navigate("detail/${amigo.name}") }
    ) {
        Surface(shape = MaterialTheme.shapes.medium, modifier = Modifier.padding(4.dp)) {
            Image(
                painter = painterResource(amigo.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                amigo.name,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary,
                // letterSpacing = 0.2.em,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(35.dp))
            Text(amigo.specie, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Chip(
                    {
                        Text(
                            text = amigo.sex,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    },
                    color = when (amigo.sex) {
                        "Female" -> Color(0xFF957DAD)
                        else -> Color(0xFFFFDFD3)
                    }
                )
                Chip(
                    {
                        Text(
                            text = amigo.years,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    },
                    color = Color(0xFFFEC8D8)
                )
                Chip(
                    { Icon(Icons.Rounded.FavoriteBorder, "") },
                    color = Color(0xFFBCE5E2)
                )
            }
        }
    }
}
