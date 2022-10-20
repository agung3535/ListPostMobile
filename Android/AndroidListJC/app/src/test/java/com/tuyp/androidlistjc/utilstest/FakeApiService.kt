package com.tuyp.androidlistjc.utilstest

import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.network.APIService

import retrofit2.Response

class FakeApiService : APIService {
    private val dummyResponse = DataDummy.generatePostDumy()
    private val dummyDetailResponse = DataDummy.generateDetailPost(1)
//    override suspend fun getNews(apiKey: String): NewsResponse {
//        return dummyResponse
//    }

    override suspend fun getAllPost(): Response<List<PostResponse>> {
        return Response.success(dummyResponse)
    }

    override suspend fun getDetailPost(postId: Int): Response<PostResponse> {
        if (dummyDetailResponse.id == postId) {
            return Response.success(dummyDetailResponse)
        }else {
            return Response.success(null)
        }
    }
}