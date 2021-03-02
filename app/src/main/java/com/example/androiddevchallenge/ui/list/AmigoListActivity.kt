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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Amigo
import com.example.androiddevchallenge.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class AmigoListActivity : AppCompatActivity() {
    private val viewModel by viewModels<AmigoListViewModel>()
    var state: ListState = ListState.Loading
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.amigosList.observe(this, ::observeState)

        setContent {
            MyTheme {
                puppyApp(state)
            }
        }
    }

    private fun observeState(listState: ListState?) {
        state = listState ?: ListState.Error
    }

    @Composable
    fun puppyApp(state: ListState) {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "list") {
            composable("list") {
                puppyList(state, navController)
            }
            composable(
                "detail/{name}",
                arguments = listOf(
                    navArgument("name") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("name")?.let {
                    detailDoggo(getDoggo(it, state))
                }
            }
        }
    }

    // Not my greatest day, no time to do it properly :(
    private fun getDoggo(name: String, state: ListState): Amigo =
        (state as ListState.Data).data.first { it.name == name }
}

@Preview("Light Theme")
@Composable
fun LightPreview() {
    MyTheme {
        detailDoggo(amigo11)
    }
}

@Preview("Dark Theme")
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        detailDoggo(amigo11)
    }
}

private val amigo11 = Amigo(
    name = "Doggy1",
    specie = "Pugdoggo",
    years = "6 years",
    description = "Most angery pupper I have ever seen vvv you are doing me the shock big ol h*ck stop it fren, what a nice floof you are doing me the shock very good spot. Snoot borkdrive boofers super chub many pats wow such tempt, sub woofer borkf aqua doggo smol doing me a frighten big ol, dat tungg tho noodle horse sub woofer doge.",
    sex = "Female",
    location = "Stadra Gård 205, 713 92 Gyttorp, Sweden",
    lastAdded = Date(),
    imageRes = R.drawable.doggo11
)
