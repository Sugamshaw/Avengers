package com.example.activity_lifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegister: TextView

    val validMobileNumber = "0123456789"
    val validPassword = arrayListOf("tony", "steve", "bruce", "thanos")

    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //shared preference object creation
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtRegister = findViewById(R.id.txtRegister)


        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)

        if(isLoggedIn){
            //intent object
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
        }
//        else{
//            setContentView(R.layout.activity_login)
//        }

        btnLogin.setOnClickListener {
            val intMobileNumber = etMobileNumber.text.toString()
            val intPassword = etPassword.text.toString()
            var nameOfAvenger: String
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            if (validMobileNumber == intMobileNumber) {

                if (intPassword == validPassword[0]) {
                    nameOfAvenger = "Tony"
                    savedPreferences(nameOfAvenger)
                    //intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                } else if (intPassword == validPassword[1]) {
                    nameOfAvenger = "Steve"
                    savedPreferences(nameOfAvenger)
                    //intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                } else if (intPassword == validPassword[2]) {
                    nameOfAvenger = "Bruce"
                    savedPreferences(nameOfAvenger)
                    //intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                } else if (intPassword == validPassword[3]) {
                    nameOfAvenger = "The Avengers"
                    savedPreferences(nameOfAvenger)
                    //intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)

                } else {
                    Toast.makeText(this@LoginActivity, "Incorrect password", Toast.LENGTH_SHORT)
                        .show()
                }

            } else {
                Toast.makeText(this@LoginActivity, "Incorrect mobile number", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }
    override fun onPause(){
        super.onPause()
        finish()
    }
    fun savedPreferences(tile:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",tile).apply()
    }

}
