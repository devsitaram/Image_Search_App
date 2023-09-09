package com.edu.imagesearch.data.common

fun HitDTO.toDomainModel(): ImageModel{
    return ImageModel(
        imageUrl = this.previewURL
    )
}