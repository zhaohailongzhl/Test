package com.hengyin.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    var result = MutableLiveData<Long>()
}