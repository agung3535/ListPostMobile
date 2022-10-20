package com.tuyp.androidlistjc.presentation.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.presentation.detail.screen.DetailScreen
import com.tuyp.androidlistjc.presentation.detail.viewmodel.DetailViewModel
import com.tuyp.androidlistjc.presentation.ui.component.LoadingCircular


@Composable
fun DetailPage(modifier: Modifier = Modifier,
               postId: Int = -1,
detailViewModel: DetailViewModel = hiltViewModel()
) {

    fun fetchData() {
        detailViewModel.getDetailPost(postId)
    }

    fetchData()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (val detailResponse = detailViewModel.detailState.value) {
            is ResponseResource.Success -> {
                detailResponse.data?.let { dataValue ->
                    DetailScreen(title = dataValue.title,
                        body = dataValue.body)
                }
            }
            is ResponseResource.Failure -> {

            }
            is ResponseResource.Loading -> {
                LoadingCircular()
            }
        }
//        DetailScreen()
    }


}

