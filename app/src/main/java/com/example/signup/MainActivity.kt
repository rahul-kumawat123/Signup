package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("LIFE_CYCLE","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etUserName = findViewById<EditText>(R.id.et_username)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPhoneNumber = findViewById<EditText>(R.id.et_phoneno)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        btnSubmit.setOnClickListener{
            if (etUserName.text.toString().isNullOrEmpty())
                etUserName.error = "Please enter Name"
            else if(etEmail.text.toString().isNullOrEmpty())
                etEmail.error = "Please enter Email ID"
            else if (etPhoneNumber.text.toString().isNullOrEmpty())
                etPhoneNumber.error = "Please enter Phone Number"
            else if (etPassword.text.toString().isNullOrEmpty())
                etPassword.error = "Please enter Password"
            else{
                val intent = Intent(this@MainActivity, UserDetails::class.java)
                intent.putExtra("Name",etUserName.text.toString())
                intent.putExtra("Email",etEmail.text.toString())
                intent.putExtra("Phone",etPhoneNumber.text.toString())
                intent.putExtra("Password",etPassword.text.toString())
                startActivity(intent)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("LIFE_CYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LIFE_CYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LIFE_CYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LIFE_CYCLE", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LIFE_CYCLE", "onDestroy")
    }
}