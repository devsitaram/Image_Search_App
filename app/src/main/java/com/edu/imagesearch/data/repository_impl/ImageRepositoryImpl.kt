package com.edu.imagesearch.data.repository_impl

import com.edu.imagesearch.data.common.toDomainModel
import com.edu.imagesearch.data.source.remote.network.ApiService
import com.edu.imagesearch.domain.model.ImageModel
import com.edu.imagesearch.domain.repository.ImageRepository
import java.lang.Exception

class ImageRepositoryImpl(private val apiService: ApiService) : ImageRepository {
    override suspend fun getSearchImage(query: String): List<ImageModel> {
        try {
            return apiService.getSearchImage(
                key = "39343490-929c50e58ac235a67f48917fa",
                query = query
            ).hits.map { it.toDomainModel() }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
    // https://pixabay.com/api/?key=39343490-929c50e58ac235a67f48917fa&q=sunflower
}