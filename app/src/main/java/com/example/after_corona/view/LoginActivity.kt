package com.example.after_corona.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityLoginBinding
import com.example.after_corona.databinding.ActivitySignupBinding
import com.example.after_corona.view.viewmodel.LoginViewModel
import com.example.after_corona.view.viewmodel.SignupViewModel

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    val viewModel : LoginViewModel by lazy {

        ViewModelProvider(this).get(LoginViewModel::class.java)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this

        binding.loginNoaccount.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }

        binding.loginBtn.setOnClickListener {

            viewModel.login(binding.loginId.text.toString(),binding.loginPasswordcontent.text.toString())


        }
        viewModel.onSuccessEvent.observe(this, Observer {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }
}