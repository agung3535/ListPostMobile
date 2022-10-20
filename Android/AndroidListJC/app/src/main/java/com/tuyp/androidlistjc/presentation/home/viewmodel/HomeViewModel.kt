package com.tuyp.androidlistjc.presentation.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.entities.repository.home.HomeRepository
import com.tuyp.androidlistjc.entities.repository.home.IHomeRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val postRepository: IHomeRepository = HomeRepository()): ViewModel() {

    private val _postState = mutableStateOf<ResponseResource<List<PostResponse>>>(ResponseResource.Success(null))
    val postState: State<ResponseResource<List<PostResponse>>> = _postState


    fun getAllPost() = viewModelScope.launch {
        postRepository.getAllPost().collect { dataValue ->
            _postState.value = dataValue
        }
    }


}