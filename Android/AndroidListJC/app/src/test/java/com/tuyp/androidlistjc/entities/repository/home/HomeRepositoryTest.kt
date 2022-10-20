package com.tuyp.androidlistjc.entities.repository.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tuyp.androidlistjc.entities.data.ResponseResource
import com.tuyp.androidlistjc.entities.data.remote.home.HomeDataSource
import com.tuyp.androidlistjc.entities.data.reponse.PostResponse
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.utilstest.DataDummy
import com.tuyp.androidlistjc.utilstest.FakeApiService
import com.tuyp.androidlistjc.utilstest.MainDispatcherRule
import com.tuyp.androidlistjc.utilstest.observeForTesting
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeRepositoryTest {
    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var apiService: APIService
    private lateinit var homeRepository: HomeRepository
    private lateinit var homeDataSource: HomeDataSource

    @Before
    fun setup() {
        apiService = FakeApiService()
        homeDataSource = HomeDataSource(apiService)
        homeRepository = HomeRepository(homeDataSource)

    }

    @Test
    fun `when getPost Should not null`() = runTest {
        val expectedPost = DataDummy.generatePostDumy()
        val actualPost = homeRepository.getAllPost()
        var statePost: State<ResponseResource<List<PostResponse>>>
        val _postState = mutableStateOf<ResponseResource<List<PostResponse>>>(ResponseResource.Success(null))
        actualPost.collect {
            Assert.assertNotNull(it)
            _postState.value = it
            statePost = _postState

            when(val data = statePost.value) {
                is ResponseResource.Success -> {
                    Assert.assertEquals(expectedPost.size,data.data?.size)
                }
                is ResponseResource.Failure -> {

                }
                is ResponseResource.Loading -> {

                }
            }
        }
    }




}