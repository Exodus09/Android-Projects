package com.example.hw1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel: ViewModel() {
    var name1 = ""
    var number1 = ""

    var name2 = ""
    var number2 = ""

    var name3 = ""
    var number3 = ""

    var contact = 1

    val currentName1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentName2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentName3: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentNumber1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentNumber2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val currentNumber3: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}