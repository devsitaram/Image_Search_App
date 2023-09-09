package com.edu.imagesearch.domain.repository

import com.edu.imagesearch.domain.model.ImageModel

interface ImageRepository {
    suspend fun getSearchImage(query: String): List<ImageModel>
}