package com.example.after_corona.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this

        binding.signupBtn.setOnClickListener {
               val intent = Intent(this, Signup2Activity::class.java)
                startActivity(intent)
            }

        }
    }



