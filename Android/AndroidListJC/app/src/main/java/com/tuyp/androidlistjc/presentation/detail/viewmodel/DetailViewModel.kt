package com.tuyp.androidlistjc.presentation.detail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.entities.repository.detail.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepository): ViewModel() {

    private val _detailState = mutableStateOf<ResponseResource<PostResponse>>(ResponseResource.Success(null))

    val detailState: State<ResponseResource<PostResponse>> = _detailState

    fun getDetailPost(postId: Int) {
        viewModelScope.launch {
            detailRepository.getDetailPost(postId).collect { dataValue ->
                _detailState.value = dataValue
            }
        }
    }


}