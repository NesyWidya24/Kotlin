package com.nessy.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ===do two think when btn is clicked===
//        ===btn to move to new activity (intent)===


        val myBtn = findViewById<Button>(R.id.btn)
        val myText = findViewById<TextView>(R.id.text)

        val myBtnIntent = findViewById<Button>(R.id.btn2)

        val  addData = findViewById<EditText>(R.id.addData)
        val  submitData = findViewById<Button>(R.id.btnSubmit)
        val  btnList = findViewById<Button>(R.id.btnList)

//        1
        myBtn.setOnClickListener {
            Toast.makeText(this, "Button is clicked", Toast.LENGTH_LONG).show()
            myText.text = getString(R.string.descText)
        }

//        2
        myBtnIntent.setOnClickListener { startActivity(Intent(this@MainActivity, NewActivity::class.java)) }

//        3
        submitData.setOnClickListener {
            val data = addData.text.toString()

            val  intent = Intent(this@MainActivity, NewActivity::class.java)
            intent.putExtra("DataText", data)
            startActivity(intent)
        }


//        4
        btnList.setOnClickListener { startActivity(Intent(this@MainActivity, NewActivity::class.java)) }
    }
}