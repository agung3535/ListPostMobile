package com.tuyp.androidlistjc.entities.repository.home

import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.remote.home.HomeDataSource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val source: HomeDataSource) {
     suspend fun getAllPost(): Flow<ResponseResource<List<PostResponse>>> = flow {
        try {
            emit(ResponseResource.Loading)
            val call = source.getAllPost()
            emit(ResponseResource.Success(call))
        }catch (e: Exception) {
            emit(ResponseResource.Failure(e))
        }
    }.flowOn(Dispatchers.IO)

//    override suspend fun getAllPostSecond(): Flow<Resource<PostResponse>> {
//        return flow<Resource<PostResponse>> {
//            emit(Resource.Loading())
//            val call = source.getAllPostSecond()
//            if (call.isSuccessful) {
//                call.body()?.let { dataCall ->
//                    emit(Resource.Success(dataCall))
//                }
//            }else {
//                emit(Resource.Error(call.message()))
//            }
//        }.flowOn(Dispatchers.IO)
//    }
}


//class HomeRepository (private val source: IHomeDataSource = HomeDataSource()): IHomeRepository {
//    override suspend fun getAllPost(): Flow<ResponseResource<List<PostResponse>>> = flow {
//        try {
//            emit(ResponseResource.Loading)
//            val call = source.getAllPost()
//            emit(ResponseResource.Success(call.body()))
//        }catch (e: Exception) {
//            emit(ResponseResource.Failure(e))
//        }
//    }.flowOn(Dispatchers.IO)
//
////    override suspend fun getAllPostSecond(): Flow<Resource<PostResponse>> {
////        return flow<Resource<PostResponse>> {
////            emit(Resource.Loading())
////            val call = source.getAllPostSecond()
////            if (call.isSuccessful) {
////                call.body()?.let { dataCall ->
////                    emit(Resource.Success(dataCall))
////                }
////            }else {
////                emit(Resource.Error(call.message()))
////            }
////        }.flowOn(Dispatchers.IO)
////    }
//}