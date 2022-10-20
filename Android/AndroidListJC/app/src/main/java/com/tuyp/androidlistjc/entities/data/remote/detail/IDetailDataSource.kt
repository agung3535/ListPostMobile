package com.tuyp.androidlistjc.entities.data.remote.detail

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import retrofit2.Response

interface IDetailDataSource {
    suspend fun getDetailPost(postId: Int): Response<PostResponse>
//    suspend fun getDetailPostSecond(postId: Int): Response<PostResponse>
}