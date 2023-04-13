package com.hengyin.test

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShowActivity : AppCompatActivity(){
    lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        var intent = intent
        textView = findViewById(R.id.textView)

        textView.setText(intent.getLongExtra("result",0).toString())


    }
}