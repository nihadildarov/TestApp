package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Home")
        menu?.add("FAQs")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.title == "Home")
            Toast.makeText(applicationContext,item.title,Toast.LENGTH_LONG).show()
        else if(item.title == "FAQs")
            Toast.makeText(applicationContext,item.title,Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }



}