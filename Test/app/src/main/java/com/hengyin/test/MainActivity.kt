package com.hengyin.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hengyin.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var button:Button
    lateinit var ed_amount:EditText
    lateinit var ed_second:EditText
    lateinit var bean: Bean
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        bean = Bean()
        binding.bean = bean
        binding.edAmount.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if(!TextUtils.isEmpty(p0)&&p0.lastIndexOf(".")!=p0.length-1)
                    bean.amount.set(it.toString().toLong())
                }
            }
        })
        binding.edSecond.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if(!TextUtils.isEmpty(p0))
                        bean.second.set(it.toString().toInt())
                }
            }
        })
        mainViewModel.result.observeForever {
            var intent = Intent(this,ShowActivity::class.java)
            intent.putExtra("result",it)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            var result = bean.amount.get()!!*bean.second!!.get().toLong()
            mainViewModel.result.postValue(result)
        }
    }
}