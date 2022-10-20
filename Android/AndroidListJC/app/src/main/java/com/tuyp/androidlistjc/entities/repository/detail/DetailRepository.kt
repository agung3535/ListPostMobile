package com.tuyp.androidlistjc.entities.repository.detail

import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.remote.detail.DetailDataSource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailRepository @Inject constructor (private val source: DetailDataSource) {
     suspend fun getDetailPost(postId: Int): Flow<ResponseResource<PostResponse>> {
        return flow {
            try {
                emit(ResponseResource.Loading)
                val call = source.getDetailPost(postId)
                emit(ResponseResource.Success(call))
            }catch (e: Exception) {
                emit(ResponseResource.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}