package com.tuyp.androidlistjc.entities.repository.home

import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import kotlinx.coroutines.flow.Flow

interface IHomeRepository {
    suspend fun getAllPost(): Flow<ResponseResource<List<PostResponse>>>
//    suspend fun getAllPostSecond(): Flow<Resource<PostResponse>>
}