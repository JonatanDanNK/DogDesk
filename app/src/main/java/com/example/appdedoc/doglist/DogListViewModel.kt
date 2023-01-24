package com.example.appdedoc.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdedoc.DogRepository
import com.example.appdedoc.api.ApiResponseStatus
import com.example.appdedoc.api.response.Dog
import kotlinx.coroutines.launch
import java.lang.Exception

class DogListViewModel: ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>> = _dogList
    private val dogListRepository = DogRepository()
    private val _status = MutableLiveData<ApiResponseStatus<List<Dog>>>()
    val status: LiveData<ApiResponseStatus<List<Dog>>> = _status


    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        viewModelScope.launch {
                //_dogList.value = dogListRepository?.downloadDogs()
            handelResponseStatus(dogListRepository.downloadDogs())
        }
    }

    private fun handelResponseStatus(apiResponseStatus: ApiResponseStatus<List<Dog>>){
        if(apiResponseStatus is ApiResponseStatus.SUCCESS){
            _dogList.value = apiResponseStatus.data
        }
        _status.value = apiResponseStatus
    }
}