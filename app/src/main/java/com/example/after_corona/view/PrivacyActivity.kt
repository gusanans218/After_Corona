package com.example.after_corona.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityLoginBinding
import com.example.after_corona.databinding.ActivityPrivacyBinding

class PrivacyActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPrivacyBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this


    }
}