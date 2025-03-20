package com.demo.jetpackcompose.repository

import com.demo.jetpackcompose.data.ProductList
import com.demo.jetpackcompose.network.ApiState

interface ProductsRepository {

    suspend fun getProductsList(): ApiState<ProductList>

}