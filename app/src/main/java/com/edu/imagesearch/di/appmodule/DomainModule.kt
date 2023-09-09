package com.edu.imagesearch.di.appmodule

import com.edu.imagesearchapp.domain.repository.ImageRepository
import com.edu.imagesearchapp.domain.use_case.GetSearchImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModel {

    @Provides
    @Singleton
    fun provideGetSearchUseCase(imageRepository: ImageRepository): GetSearchImageUseCase {
        return GetSearchImageUseCase(imageRepository)
    }
}