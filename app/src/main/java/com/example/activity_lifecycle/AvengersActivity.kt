package com.example.activity_lifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var edMessage: EditText
    lateinit var btnSendMessage: Button
    lateinit var btnLogOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)
        //sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        edMessage = findViewById(R.id.edMessage)
        btnSendMessage = findViewById(R.id.btnSendMessage)
        btnLogOut = findViewById(R.id.btnLogOut)


        titleName =
            sharedPreferences.getString("Title","The Avengers")//default value "the avengers"
        title = titleName




        btnSendMessage.setOnClickListener {
            val intent = Intent(this@AvengersActivity, Messages_Activity::class.java)
            val text = edMessage.text.toString()
            intent.putExtra("Message", text)
            startActivity(intent)
        }
        btnLogOut.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            finish()
        }

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
