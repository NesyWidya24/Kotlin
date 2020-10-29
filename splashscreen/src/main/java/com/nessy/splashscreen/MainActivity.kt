package com.nessy.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ===do two think when btn is clicked===
//        ===btn to move to new activity (intent)===

//        1
        btn.setOnClickListener {
            Toast.makeText(this, "Button is clicked", Toast.LENGTH_LONG).show()
            text.text = getString(R.string.descText)
        }

//        2
        btn2.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    NewActivity::class.java
                )
            )
        }

//        3
        btnSubmit.setOnClickListener {
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
        btnShowAlertDialog.setOnClickListener {
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


//        7
        btnSingleAlertDialog.setOnClickListener {
            val listItems = arrayOf("Item 1 ", "Item 2", "Item 3")
            val mBuilder = AlertDialog.Builder(this@MainActivity)
            mBuilder.setTitle("Choose an action")
            mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
//                set text
                txtResult.text = listItems[i]
//                dismiss dialog
                dialogInterface.dismiss()
            }
//            set neutral/cancel btn
            mBuilder.setNeutralButton("Cancel") { dialog, which ->
//                just dismiss the alertDialog
                dialog.cancel()
            }
//            create and show alert dialog
            val mDialog = mBuilder.create()
            mDialog.show()
        }


//        8
        btnAlertDialog.setOnClickListener {
//            alert dialog builder
            val builder = AlertDialog.Builder(this@MainActivity)
//            list or items to be displayed in alert dialog
            val colorArray = arrayOf("Black", "Orange", "Green", "Yellow", "Purple", "White")
//            initially select some colors
            val checkedColorsArray = booleanArrayOf(
                true, //black selected
                false, //orange
                false, //green
                true, //yellow
                false, //white
                false, //purple
            )
            val colorsList = Arrays.asList(*colorArray)
            //set title of alert dialog
            builder.setTitle("Select colors")
            //make alert dialog multi choice
            builder.setMultiChoiceItems(
                colorArray,
                checkedColorsArray
            ) { dialog, which, isChecked ->
                //update the current focused item's checked status
                checkedColorsArray[which] = isChecked
                //get the current focused item
                val currentItem = colorsList[which]
                //notify the current action
                Toast.makeText(
                    applicationContext,
                    "$currentItem $isChecked", //make simple from this currentItem + " " + isChecked,
                    Toast.LENGTH_SHORT
                ).show()
            }
            //get positive/yes button
            builder.setPositiveButton("Ok") { dialog, which ->
                //do something when click positive button
                txtView.text = R.string.descPositive.toString()
                for (i in checkedColorsArray.indices) {
                    val checked = checkedColorsArray[i]
                    if (checked) {
                        txtView.text = txtView.text.toString() + colorsList[i] + "\n"
                    }
                }
            }
            //set neutral or cancel button
            builder.setNeutralButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
}