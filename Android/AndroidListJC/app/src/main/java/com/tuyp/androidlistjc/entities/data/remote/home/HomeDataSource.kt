package com.tuyp.androidlistjc.entities.data.remote.home

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.network.RetrofitInstance
import retrofit2.Response

class HomeDataSource(private val apiService: APIService = RetrofitInstance.api): IHomeDataSource {
    override suspend fun getAllPost(): Response<List<PostResponse>> = apiService.getAllPost()

//    override suspend fun getAllPostSecond(): Response<PostResponse> = RetrofitInstance.api.getAllPost()
}