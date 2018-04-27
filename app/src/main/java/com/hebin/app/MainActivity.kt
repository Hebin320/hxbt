package com.hebin.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hebin.hxbr.texts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMain.texts = "我是谁"
    }
}
