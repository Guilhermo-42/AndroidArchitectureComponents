package com.example.viewmodel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(var context: Application): AndroidViewModel(context) {

    val numeroLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun onButtonPressed() {
        val newNumero = numeroLiveData.value?.plus(1) ?: 0

        numeroLiveData.postValue(newNumero)
    }

}