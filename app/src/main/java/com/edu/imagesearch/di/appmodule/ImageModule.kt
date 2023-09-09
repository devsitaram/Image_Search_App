package com.edu.imagesearch.di.appmodule

import com.edu.imagesearch.data.repository_impl.ImageRepositoryImpl
import com.edu.imagesearch.data.source.remote.network.ApiService
import com.edu.imagesearch.data.source.remote.network.BASE_URL
import com.edu.imagesearchapp.data.source.remote.network.ApiService
import com.edu.imagesearchapp.data.source.remote.network.BASE_URL
import com.edu.imagesearchapp.data.repository.ImageRepositoryImpl
import com.edu.imagesearchapp.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// this is app level module
@InstallIn(SingletonComponent::class)
@Module
object ImageModule {

    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(ApiService::class.java)
    }

    @Provides
    fun provideImageRepo(apiService: ApiService): ImageRepository {
        return ImageRepositoryImpl(apiService)
    }
}