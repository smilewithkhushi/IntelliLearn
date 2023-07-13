package com.example.intellilearnthestudyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {

    lateinit var firebaseAuth : FirebaseAuth
    lateinit var inputEmail : TextInputEditText
    lateinit var inputPassword : TextInputEditText
    lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inputEmail = findViewById(R.id.emailTextView)
        inputPassword = findViewById(R.id.passwordTextView)
        loginBtn = findViewById(R.id.loginButton)
        firebaseAuth = FirebaseAuth.getInstance()

        loginBtn.setOnClickListener {

            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please enter email or password!", Toast.LENGTH_SHORT).show()
            }else{
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    task ->
                    if (task.isSuccessful){
                        val intent = Intent(this, dashboard::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "Invalid Email or password!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

        val signupButton = findViewById<Button>(R.id.signUpBtn)
        signupButton.setOnClickListener {
            intent = Intent(this, signup::class.java)
            startActivity(intent)
        }

    }
}

