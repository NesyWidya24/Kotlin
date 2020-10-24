package com.nessy.kotlinfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if u want to change the text programmatically
        val jText = findViewById<TextView>(R.id.text)
        jText.text = getString(R.string.Jtext)
    }
}