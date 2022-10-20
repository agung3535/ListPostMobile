package com.tuyp.androidlistjc.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.presentation.home.screen.PostScreen
import com.tuyp.androidlistjc.presentation.home.viewmodel.HomeViewModel
import com.tuyp.androidlistjc.presentation.ui.component.LoadingCircular
import com.tuyp.androidlistjc.presentation.ui.component.SearchComponent
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickData: (Int) -> Unit = {}
) {
    homeViewModel.getAllPost()
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        Column() {
            SearchComponent(state = textState)
            when(val postResponse = homeViewModel.postState.value) {
                is ResponseResource.Success -> {
                    PostScreen(postList = postResponse.data,
                        state = textState, onClickData = onClickData)
                }
                is ResponseResource.Failure -> {
                    Log.d("dataaaa1","masuk error")
                }

                is ResponseResource.Loading -> {
                    LoadingCircular( modifier = modifier.fillMaxWidth())
                }
            }
        }

    }
}


@Preview
@Composable
fun HomePagePreview() {
    HomePage()
}