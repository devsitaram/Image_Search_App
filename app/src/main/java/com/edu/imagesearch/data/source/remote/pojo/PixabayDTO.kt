package com.edu.imagesearch.data.source.remote.pojo

import com.edu.imagesearch.data.source.remote.pojo.HitDTO

data class PixabayDTO(
    val hits: List<HitDTO>,
    val total: Int,
    val totalHits: Int
)