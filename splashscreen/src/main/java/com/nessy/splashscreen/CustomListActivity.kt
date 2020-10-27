package com.nessy.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class CustomListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var listview = findViewById<ListView>(R.id.listView)

        var list = mutableListOf<Model>()

        list.add(Model("Title One", "Description One...", R.drawable.img1))
        list.add(Model("Title Two", "Description Two...", R.drawable.img2))
        list.add(Model("Title Three", "Description Three...", R.drawable.img3))
        list.add(Model("Title Four", "Description Four...", R.drawable.img4))
        list.add(Model("Title Five", "Description Five...", R.drawable.img5))

        listview.adapter = ListAdapter(this, R.layout.row, list)

//        handle item clicked
        listview.setOnItemClickListener { parent, view, position, id ->
            if (position==0){
                Toast.makeText(this@CustomListActivity, "Item One Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position==1){
                Toast.makeText(this@CustomListActivity, "Item Two Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position==2){
                Toast.makeText(this@CustomListActivity, "Item Three Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position==3){
                Toast.makeText(this@CustomListActivity, "Item Four Clicked...", Toast.LENGTH_SHORT).show()
            }
            if (position==4){
                Toast.makeText(this@CustomListActivity, "Item Five Clicked...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}