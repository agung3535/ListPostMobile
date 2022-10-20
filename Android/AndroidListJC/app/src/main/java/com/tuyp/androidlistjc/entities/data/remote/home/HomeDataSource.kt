package com.tuyp.androidlistjc.entities.data.remote.home

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.network.RetrofitInstance
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeDataSource @Inject constructor(private val apiService: APIService) {
    suspend fun getAllPost(): List<PostResponse> = apiService.getAllPost()
}
