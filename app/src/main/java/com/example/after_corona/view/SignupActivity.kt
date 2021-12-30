package com.example.after_corona.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivitySignupBinding
import com.example.after_corona.view.viewmodel.SignupViewModel
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    val viewModel: SignupViewModel by lazy {
        ViewModelProvider(this).get(SignupViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.activity = this



        binding.signupBtn.setOnClickListener {

            if (binding.passwordcontent.text.toString().trim()
                    .isNotEmpty() && binding.signupId.text.toString().trim().isNotEmpty() &&
                binding.signupRepwContent.text.toString().trim().isNotEmpty() &&
                binding.passwordcontent.text.toString().trim() == binding.signupRepwContent.text.toString().trim()&&
                binding.passwordcontent.text.toString().trim()
                    .count() >= 8 && binding.passwordcontent.text.toString().trim().count() <= 20
            ) {
                val intent = Intent(this, Signup2Activity::class.java)
                intent.putExtra("signupId", binding.signupId.text.toString().trim())
                intent.putExtra("passwordContent", binding.passwordcontent.text.toString().trim())
                startActivity(intent)
                finish()





            } else {
                Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
            }


        }

        binding.yesaccount.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }



    }


}



