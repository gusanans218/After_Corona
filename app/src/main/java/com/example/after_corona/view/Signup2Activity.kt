package com.example.after_corona.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivitySignup2Binding
import com.example.after_corona.databinding.ActivitySignupBinding

class Signup2Activity : AppCompatActivity() {
    private val binding by lazy { ActivitySignup2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this

        binding.signupBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.yesaccount2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}