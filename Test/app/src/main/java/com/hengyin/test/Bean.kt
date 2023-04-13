package com.hengyin.test

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class Bean {
    var amount = ObservableField<Long>()
    var second = ObservableInt()
}