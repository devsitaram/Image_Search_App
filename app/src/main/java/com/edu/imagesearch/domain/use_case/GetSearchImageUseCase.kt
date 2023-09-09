package com.edu.imagesearch.domain.use_case

import com.edu.imagesearch.data.common.Resource
import com.edu.imagesearch.domain.model.ImageModel
import com.edu.imagesearch.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetSearchImageUseCase(private val imageRepository: ImageRepository) {

    operator fun invoke(query: String): Flow<Resource<List<ImageModel>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = imageRepository.getSearchImage(query = query)))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}