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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.AmigosRepository
import com.example.androiddevchallenge.domain.Amigo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AmigoListViewModel @Inject constructor(var amigosRepository: AmigosRepository) : ViewModel() {
    private val amigosLiveData = MutableLiveData<ListState>()
    val amigosList: LiveData<ListState>
        get() = amigosLiveData

    init {
        amigosLiveData.postValue(ListState.Loading)
        amigosLiveData.postValue(ListState.Data(amigosRepository.getAllAmigos()))
    }
}

sealed class ListState {
    object Loading : ListState()
    object Error : ListState()
    class Data(val data: List<Amigo>) : ListState()
}
