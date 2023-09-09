package com.edu.imagesearch.data.common

import com.edu.imagesearch.data.source.remote.pojo.HitDTO

fun HitDTO.toDomainModel(): ImageModel{
    return ImageModel(
        imageUrl = this.previewURL
    )
}