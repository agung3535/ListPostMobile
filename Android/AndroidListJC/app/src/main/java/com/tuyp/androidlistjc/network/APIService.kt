package com.tuyp.androidlistjc.network

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("posts")
    suspend fun getAllPost(): Response<List<PostResponse>>

    @GET("posts/{id}")
    suspend fun getDetailPost(@Path("id") postId: Int): Response<PostResponse>

}