package com.tuyp.androidlistjc.entities.repository.detail

import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.remote.detail.DetailDataSource
import com.tuyp.androidlistjc.entities.data.remote.detail.IDetailDataSource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailRepository(private val source: IDetailDataSource = DetailDataSource()): IDetailRepository {
    override suspend fun getDetailPost(postId: Int): Flow<ResponseResource<PostResponse>> {
        return flow {
            try {
                emit(ResponseResource.Loading)
                val call = source.getDetailPost(postId)
                emit(ResponseResource.Success(call.body()))
            }catch (e: Exception) {
                emit(ResponseResource.Failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}