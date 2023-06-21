package com.example.activity_lifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var titleName:String?="Avengers"
    lateinit var sharedPreferences:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrollview_example)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)


//        if(intent!=null){
//            titleName=intent.getStringExtra("Name")
//        }

        titleName=sharedPreferences.getString("Title","abc")
        title=titleName
    }


    /*override fun onStart() {
        super.onStart()
        println("onStart called")
    }

    override fun onResume() {
        super.onResume()
        println("onResume called")
    }
    override fun onPause() {
        super.onPause()
        println("onPause called")
    }

    override fun onStop() {
        super.onStop()
        println("onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy called")
    }*/

}
