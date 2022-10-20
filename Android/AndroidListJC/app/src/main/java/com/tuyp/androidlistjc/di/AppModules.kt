package com.tuyp.androidlistjc.di

import com.tuyp.androidlistjc.entities.data.remote.detail.DetailDataSource
import com.tuyp.androidlistjc.entities.data.remote.home.HomeDataSource
import com.tuyp.androidlistjc.entities.repository.detail.DetailRepository
import com.tuyp.androidlistjc.entities.repository.home.HomeRepository
import com.tuyp.androidlistjc.network.APIService
import com.tuyp.androidlistjc.utils.ConstVal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ConstVal.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    @Provides
    fun provideHomeRemoteData(apiService: APIService): HomeDataSource =
        HomeDataSource(apiService)

    @Provides
    fun provideHomeRepository(dataSource: HomeDataSource): HomeRepository =
        HomeRepository(dataSource)

    @Provides
    fun provideDetailDataSource(apiService: APIService): DetailDataSource =
        DetailDataSource(apiService)

    @Provides
    fun provideDetailRepository(dataSource: DetailDataSource): DetailRepository =
        DetailRepository(dataSource)
}