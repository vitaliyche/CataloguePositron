package com.codeliner.cataloguepositron.data.repository

import com.codeliner.cataloguepositron.data.api.RetrofitInstance
import com.codeliner.cataloguepositron.model.CatalogueModel
import retrofit2.Response

class Repository {
    suspend fun getCatalogueRepo(): Response<CatalogueModel> {
        return RetrofitInstance.api.getCatalogueApi()
    }
}