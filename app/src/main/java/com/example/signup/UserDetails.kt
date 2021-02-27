package com.example.signup

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

class UserDetails : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("LIFE_CYCLE","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val password = intent.getStringExtra("Password")

        val result = findViewById<TextView>(R.id.et_details)

        result.text = "Name: "+name+"\nEmail: "+email+"\nPhone: "+phone+"\nPassword: "+password

        val etUrl = findViewById<EditText>(R.id.et_url)
        val btnUrl = findViewById<Button>(R.id.btn_url)
        val btnPermission = findViewById<Button>(R.id.btn_permission)

        btnUrl.setOnClickListener{
            val implicit = Intent(Intent.ACTION_VIEW , Uri.parse(etUrl.text.toString()))
            startActivity(implicit)
        }

        btnPermission.setOnClickListener{
            val v = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA")
            when(v){
                PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
                }
                PackageManager.PERMISSION_DENIED -> {
                    //Toast.makeText(applicationContext,"Permission Denied",Toast.LENGTH_SHORT).show()

                   val v = shouldShowRequestPermissionRationale("android.permission.CAMERA")
                   if (v){
                       askForPermission()
                   }else
                   {
                       Toast.makeText(applicationContext,"Ask User to Give Permission from Settings Menu",Toast.LENGTH_SHORT).show()
                   }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun askForPermission() {
        val permissions = arrayOf("android.permissions.CAMERA")
        requestPermissions(permissions,1001)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext ,"Permission Granted ${permissions[0]}",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext ,"Permission Denied ${permissions[0]}",Toast.LENGTH_SHORT).show()
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