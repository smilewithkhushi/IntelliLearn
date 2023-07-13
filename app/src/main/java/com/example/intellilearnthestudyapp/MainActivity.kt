package com.example.intellilearnthestudyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getStartedBtn = findViewById<Button>(R.id.getStartedButton)
        getStartedBtn.setOnClickListener {

            intent = Intent (this, login::class.java)
            startActivity(intent)
        }
    }
}