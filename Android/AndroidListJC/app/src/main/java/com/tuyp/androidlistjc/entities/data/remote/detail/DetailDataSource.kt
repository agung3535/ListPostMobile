package com.tuyp.androidlistjc.entities.data.remote.detail

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.network.RetrofitInstance
import retrofit2.Response

class DetailDataSource(val apiService: APIService = RetrofitInstance.api): IDetailDataSource {
    override suspend fun getDetailPost(postId: Int): Response<PostResponse> = apiService.getDetailPost(postId)

//    override suspend fun getDetailPostSecond(postId: Int): Response<PostResponse> = RetrofitInstance.api.getDetailPost(postId)
}