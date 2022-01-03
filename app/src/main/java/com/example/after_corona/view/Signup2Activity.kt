package com.example.after_corona.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivitySignup2Binding
import com.example.after_corona.databinding.ActivitySignupBinding
import com.example.after_corona.view.viewmodel.SignupViewModel

class Signup2Activity : AppCompatActivity() {
    private val binding by lazy { ActivitySignup2Binding.inflate(layoutInflater) }
    val viewModel : SignupViewModel by lazy {

        ViewModelProvider(this).get(SignupViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this


        binding.signupBtn.setOnClickListener {
            if (binding.signupName.text.toString().trim()
                    .isNotEmpty() && binding.signupPhonenumbercontent.text.toString().trim()
                    .isNotEmpty()
            ) {
                viewModel.signup(
                    id = intent.getStringExtra("signupId") ?: "",
                    name = binding.signupName.text.toString().trim(),
                    phoneNumber =binding.signupPhonenumbercontent.text.toString().trim(),
                    password = intent.getStringExtra("passwordContent") ?: "",
                    duraction = 600000,
                    callbackUrl = "https://key-del-jeeinho.github.io/after-corona-api/Welcome.html"
                )


            }
            intent.getStringExtra("signupId")
            intent.getStringExtra("passwordContent")


        }
        viewModel.onSuccessEvent.observe(this, Observer {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })

        viewModel.onFailureEvent.observe(this, Observer {
            Toast.makeText(this,"통신 에러가 발생하였습니다",Toast.LENGTH_SHORT).show()
        })

        binding.yesaccount2.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        binding.signupCertificationOk.setOnClickListener {
            val dialogUp = PhoneDialog(this,binding.signupName.text.toString().trim())
            dialogUp.show()
        }
    }
}