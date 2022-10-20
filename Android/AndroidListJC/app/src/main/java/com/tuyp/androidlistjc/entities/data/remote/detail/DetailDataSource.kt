package com.tuyp.androidlistjc.entities.data.remote.detail

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.network.RetrofitInstance
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailDataSource @Inject constructor(val apiService: APIService) {
    suspend fun getDetailPost(postId: Int): PostResponse = apiService.getDetailPost(postId)

}