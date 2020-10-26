package com.nessy.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val  actionBar = supportActionBar //actionBar
        actionBar!!.title = "New Activity" //setActionBar title
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val data = intent.getStringExtra("DataText")

//        text view
        val resultData = findViewById<TextView>(R.id.resultData)
//        setText
        resultData.text = data
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}