package com.edu.imagesearch.presentation.state

import com.edu.imagesearch.domain.model.ImageModel

data class ImageState(
    val isLoading: Boolean = false,
    val data: List<ImageModel>? = null,
    val error: String = ""
)