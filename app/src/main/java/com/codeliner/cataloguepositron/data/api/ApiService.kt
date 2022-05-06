package com.codeliner.cataloguepositron.data.api

import com.codeliner.cataloguepositron.model.CatalogueModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products?cat_id=869&limit=10&offset=0&base_id=1&sort_type=1")
    suspend fun getCatalogueApi(): Response<CatalogueModel>
}