package com.nessy.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //arra of items to be displayed in listView
        val values = arrayListOf("Item One", "Item Two", "Item Three", "Item Four")

//        listView
        val mListView = findViewById<ListView>(R.id.listData)

//        adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values)
//        set adapter
        mListView.adapter = adapter
//        list item click
        mListView.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                Toast.makeText(this@ListView, "Item One Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position == 1) {
                Toast.makeText(this@ListView, "Item Two Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position == 2) {
                Toast.makeText(this@ListView, "Item Three Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position == 3) {
                Toast.makeText(this@ListView, "Item Four Clicked...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}