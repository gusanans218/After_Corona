package com.example.after_corona.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.adapters.ToolbarBindingAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityLoginBinding
import com.example.after_corona.databinding.ActivityPrivacyBinding
import com.example.after_corona.view.data.Constant
import com.example.after_corona.view.fragment.UserFragment
import com.example.after_corona.view.viewmodel.LoginViewModel
import com.example.after_corona.view.viewmodel.UserViewModel

class PrivacyActivity : AppCompatActivity() {
    private val binding by lazy { ActivityPrivacyBinding.inflate(layoutInflater) }
    val viewModel : UserViewModel by lazy {

        ViewModelProvider(this).get(UserViewModel::class.java)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this


        binding.privacyBtn.setOnClickListener {
            if(binding.privacyPasswordContent.text.toString().trim().isNotEmpty()&&
                    binding.privacyPhoneContent.text.toString().trim().isNotEmpty()&&
                    binding.privacyNameContent.text.toString().trim().isNotEmpty())
            {
                viewModel.putUser(Constant.id,binding.privacyPasswordContent.text.toString().trim(),
                    binding.privacyPhoneContent.text.toString().trim(),binding.privacyNameContent.text.toString().trim())
            }
            else{
                Toast.makeText(this,"빈 칸이 있습니다",Toast.LENGTH_SHORT).show()

            }
        }

        binding.writeToolbarBack.setOnClickListener {
            finish()
        }

        viewModel.getUser(Constant.id)
        viewModel.userData.observe(this,{
            binding.privacyIdContent.text = it.id
            binding.privacyPasswordContent.setText(Constant.password)
            binding.privacyNameContent.setText(it.name)
            binding.privacyPhoneContent.setText(it.phoneNumber)
        })

        viewModel.onSuccessEvent.observe(this,{
            Constant.password = binding.privacyPasswordContent.text.toString().trim()
            finish()
        })



    }
}