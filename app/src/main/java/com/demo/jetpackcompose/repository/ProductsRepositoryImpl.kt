package com.demo.jetpackcompose.repository

import com.demo.jetpackcompose.data.ProductList
import com.demo.jetpackcompose.network.ApiException
import com.demo.jetpackcompose.network.ApiService
import com.demo.jetpackcompose.network.ApiState
import com.demo.jetpackcompose.network.suspendedNetworkGetRequest
import com.demo.jetpackcompose.repository.mapper.ProductsListMapper
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductsRepository {

    override suspend fun getProductsList(): ApiState<ProductList> {
        return suspendedNetworkGetRequest(
            fetch = {
                apiService.getProductList()
            },
            map = { response ->
                ProductsListMapper.mapData(response)
            },
            onSuccess = {
            },
            onMappingFailure = { mappingFailure -> Timber.e(mappingFailure) },
            onApiFailure = { apiFailure -> Timber.e(ApiException(apiFailure)) },
            dispatcher = Dispatchers.IO
        )
    }
}