package com.tuyp.androidlistjc.entities.repository.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.remote.detail.DetailDataSource
import com.tuyp.androidlistjc.entities.data.remote.detail.IDetailDataSource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.entities.repository.home.HomeRepository
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.utilstest.DataDummy
import com.tuyp.androidlistjc.utilstest.FakeApiService
import com.tuyp.androidlistjc.utilstest.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailRepositoryTest {


    private lateinit var apiService: APIService
    private lateinit var detailRepository: DetailRepository
    private lateinit var dataSource: IDetailDataSource

    @Before
    fun setup() {
        apiService = FakeApiService()
        dataSource = DetailDataSource(apiService = apiService)
        detailRepository = DetailRepository(dataSource)
    }




    @Test
    fun `when get post detail should not null`() = runTest {
        val expectedPost = DataDummy.generateDetailPost(1)
        val actualPost = detailRepository.getDetailPost(1)
        var statePost: State<ResponseResource<PostResponse>>
        val _postState = mutableStateOf<ResponseResource<PostResponse>>(ResponseResource.Success(null))
        actualPost.collect {
            Assert.assertNotNull(it)
            _postState.value = it
            statePost = _postState

            when(val data = statePost.value) {
                is ResponseResource.Success -> {
                    Assert.assertEquals(expectedPost.id,data.data?.id)
                }
                is ResponseResource.Failure -> {

                }
                is ResponseResource.Loading -> {

                }
            }
        }

    }
}