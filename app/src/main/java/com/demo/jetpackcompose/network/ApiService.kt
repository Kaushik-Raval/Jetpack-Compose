package com.demo.jetpackcompose.network

import com.demo.jetpackcompose.data.ProductResponse
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProductList(): Response<ProductResponse>
}