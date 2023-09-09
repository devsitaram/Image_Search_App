package com.edu.imagesearchapp.data.source.remote.pojo

data class PixabayDTO(
    val hits: List<HitDTO>,
    val total: Int,
    val totalHits: Int
)