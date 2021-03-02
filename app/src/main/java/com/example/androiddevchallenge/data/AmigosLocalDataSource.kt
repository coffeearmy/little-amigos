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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Amigo
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AmigosLocalDataSource @Inject constructor() {
    val amigosList: List<Amigo>
        get() {
            return listOf<Amigo>(
                amigo1,
                amigo2,
                amigo3,
                amigo4,
                amigo5,
                amigo6,
                amigo7,
                amigo8,
                amigo9,
                amigo10,
                amigo11
            )
        }
    private val amigo1 = Amigo(
        name = "Donut",
        specie = "Affenpinscher",
        years = "4 years",
        description = "Doggo ipsum shoob floofs doge dat tungg tho noodle horse, borkf adorable doggo dat tungg tho snoot, such treat big ol shoob.",
        sex = "Male",
        location = "PE-38, Alto de la Alianza, Peru",
        lastAdded = Date(),
        imageRes = R.drawable.doggo1
    )
    private val amigo2 = Amigo(
        name = "Eclair",
        specie = "Airedale",
        years = "6 months",
        description = "Wrinkler super chub dat tungg tho puggorino you are doin me a concern the neighborhood pupper, thicc noodle horse borkf pats. ",
        sex = "Female",
        location = "1 Fen Ct, Langbourn, London EC3M 5BN, UK",
        lastAdded = Date(),
        imageRes = R.drawable.doggo2
    )
    private val amigo3 = Amigo(
        name = "Froyo",
        specie = "Akita",
        years = " year",
        description = "He made many woofs doge length boy doge the neighborhood pupper, corgo tungg. ",
        sex = "Female",
        location = "Avenue Rogier 51, 1030 Schaerbeek, Belgium",
        lastAdded = Date(),
        imageRes = R.drawable.doggo3
    )
    private val amigo4 = Amigo(
        name = "Gingerbread",
        specie = "Appenzeller",
        years = " 10 years",
        description = "Ruff long woofer aqua doggo super chub I am bekom fat borkf long water shoob, shooberino puggorino what a nice floof aqua doggo corgo.",
        sex = "Male",
        location = "Schillerstraße 15, 72458 Albstadt, Germany",
        lastAdded = Date(),
        imageRes = R.drawable.doggo4
    )
    private val amigo5 = Amigo(
        name = "HoneyComb",
        specie = "Appenzeller",
        years = "2 years",
        description = "Doggorino borkf heck shoober dat tungg tho fluffer, much ruin diet heckin angery woofer smol borking doggo with a long snoot for pats. ",
        sex = "Female",
        location = "Petersburg, 72458 Albstadt, Germany",
        lastAdded = Date(),
        imageRes = R.drawable.doggo5
    )
    private val amigo6 = Amigo(
        name = "IceCream",
        specie = "Basenji",
        years = "5 years",
        description = "Much ruin diet heckin angery woofer smol borking doggo with a long snoot for pats. length boy, very jealous pupper puggorino borkf. ",
        sex = "Male",
        location = "Kreuzner Str. 71, 9710, Austria",
        lastAdded = Date(),
        imageRes = R.drawable.doggo6
    )
    private val amigo7 = Amigo(
        name = "Jelly Bean",
        specie = "Beagle",
        years = "12 years",
        description = "Pats corgo adorable doggo you are doing me the shock waggy wags, pupper super chub fat boi.",
        sex = "Male",
        location = "Corso Umberto I, 16, 86030 Castelbottaccio CB, Italy",
        lastAdded = Date(),
        imageRes = R.drawable.doggo7
    )
    private val amigo8 = Amigo(
        name = "KitCat",
        specie = "Beagle",
        years = "1 year",
        description = "The neighborhood pupper floofs long water shoob fluffer mlem wrinkler long bois heck, wrinkler fat boi stop it fren the neighborhood pupper long woofer. ",
        sex = "Male",
        location = "",
        lastAdded = Date(),
        imageRes = R.drawable.doggo8
    )
    private val amigo9 = Amigo(
        name = "Lollipop",
        specie = "Boxer",
        years = "3 months",
        description = "Such treat much ruin diet woofer waggy wags, heckin good boys sub woofer. Extremely cuuuuuute.Very jealous pupper ur givin me a spook floofs smol borking doggo with a long snoot for pats puggorino many pats, doing me a frighten heckin good boys and girls maximum borkdrive",
        sex = "Male",
        location = "Calle de Joaquín Costa, 4-18, 22592 Peñalba, Huesca",
        lastAdded = Date(),
        imageRes = R.drawable.doggo9
    )
    private val amigo10 = Amigo(
        name = "Marshmallow",
        specie = "Chow",
        years = "4 years",
        description = "Very good spot noodle horse you are doing me the shock vvv clouds, heckin good boys and girls waggy wags. pats boof. Doggorino fluffer doggorino you are doing me a frighten borkdrive, pupperino dat tungg tho I am bekom fat. ",
        sex = "Female",
        location = "Carrer dels Apenins, 37-19, 08207 Sabadell, Barcelona",
        lastAdded = Date(),
        imageRes = R.drawable.doggo10
    )
    private val amigo11 = Amigo(
        name = "Nougat",
        specie = "Pug",
        years = "6 years",
        description = "Most angery pupper I have ever seen vvv you are doing me the shock big ol h*ck stop it fren, what a nice floof you are doing me the shock very good spot. Snoot borkdrive boofers super chub many pats wow such tempt, sub woofer borkf aqua doggo smol doing me a frighten big ol, dat tungg tho noodle horse sub woofer doge.",
        sex = "Female",
        location = "Stadra Gård 205, 713 92 Gyttorp, Sweden",
        lastAdded = Date(),
        imageRes = R.drawable.doggo11
    )
}
