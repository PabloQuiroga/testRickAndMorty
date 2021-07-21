package com.siar.testrickandmortyapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siar.testrickandmortyapi.api.RetrofitClient
import com.siar.testrickandmortyapi.api.model.RMResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class PersonageViewModel: ViewModel() {
    val personageModel: MutableLiveData<Response<RMResponse>> = MutableLiveData()

    fun getAllData(){
        CoroutineScope(Dispatchers.Main).launch{
            val serieData = RetrofitClient.apiService.getAllCharacters()
            if (serieData.isSuccessful){
                personageModel.postValue(serieData)
            }
        }
    }
}

