package com.tuyp.androidlistjc.entities.repository.detail

import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import kotlinx.coroutines.flow.Flow

interface IDetailRepository {
    suspend fun getDetailPost(postId: Int): Flow<ResponseResource<PostResponse>>
//    suspend fun getDetailPostSecond(postId: Int): Flow<Resource<PostResponse>>
}