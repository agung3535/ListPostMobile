package com.tuyp.androidlistjc.entities.data.remote.home

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import retrofit2.Response

interface IHomeDataSource {
    suspend fun getAllPost(): Response<List<PostResponse>>
//    suspend fun getAllPostSecond(): Response<PostResponse>
}