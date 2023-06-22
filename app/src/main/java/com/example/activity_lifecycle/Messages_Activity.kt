package com.example.activity_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Messages_Activity : AppCompatActivity() {
    lateinit var txtMessageReceive: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        title = "Message"

        txtMessageReceive = findViewById(R.id.txtMessageReceive)
        if (intent != null) {
            val message=intent.getStringExtra("Message")
            txtMessageReceive.text = message
        }
    }
}