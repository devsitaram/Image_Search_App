package com.edu.imagesearch.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edu.imagesearch.data.common.Resource
import com.edu.imagesearch.domain.use_case.GetSearchImageUseCase
import com.edu.imagesearch.presentation.state.ImageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val getSearchImageUseCase: GetSearchImageUseCase) :
    ViewModel() {

    private val _imageList = mutableStateOf(ImageState())
    val imageList: State<ImageState> get() = _imageList

    init {
        getSearchImage("sunflower")
    }

    private fun getSearchImage(query: String) {
        getSearchImageUseCase(query).onEach {
            when (it) {
                is Resource.Loading -> {
                    _imageList.value = ImageState(isLoading = true)
                }
                is Resource.Success -> {
                    _imageList.value = ImageState(data = it.data)
                }
                is Resource.Error -> {
                    _imageList.value = ImageState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}