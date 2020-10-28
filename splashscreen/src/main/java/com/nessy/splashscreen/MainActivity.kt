package com.nessy.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ===do two think when btn is clicked===
//        ===btn to move to new activity (intent)===


        val myBtn = findViewById<Button>(R.id.btn)
        val myText = findViewById<TextView>(R.id.text)
        val myBtnIntent = findViewById<Button>(R.id.btn2)
        val addData = findViewById<EditText>(R.id.addData)
        val submitData = findViewById<Button>(R.id.btnSubmit)
        val btnList = findViewById<Button>(R.id.btnList)
        val btnCustomList = findViewById<Button>(R.id.btnCustomList)
        val btnAlertDialog = findViewById<Button>(R.id.btnShowAlertDialog)

//        1
        myBtn.setOnClickListener {
            Toast.makeText(this, "Button is clicked", Toast.LENGTH_LONG).show()
            myText.text = getString(R.string.descText)
        }

//        2
        myBtnIntent.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    NewActivity::class.java
                )
            )
        }

//        3
        submitData.setOnClickListener {
            val data = addData.text.toString()

            val intent = Intent(this@MainActivity, NewActivity::class.java)
            intent.putExtra("DataText", data)
            startActivity(intent)
        }


//        4
        btnList.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ListView::class.java
                )
            )
        }
//        5
        btnCustomList.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    ListView::class.java
                )
            )
        }
//        6
        btnAlertDialog.setOnClickListener {
            val mAlert = AlertDialog.Builder(this@MainActivity)
            mAlert.setTitle("Title")
            mAlert.setMessage("This Alert Dialog...")
            mAlert.setIcon(R.mipmap.ic_launcher)
            mAlert.setPositiveButton("Yes") { dialog, id ->
//                perform action when user click yes
                Toast.makeText(this@MainActivity, "Yes", Toast.LENGTH_SHORT).show()
            }
            mAlert.setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
            mAlert.show()
        }
    }
}