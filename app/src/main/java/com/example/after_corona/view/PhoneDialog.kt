package com.example.after_corona.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivitySignupBinding
import com.example.after_corona.databinding.PhoneDialogBinding

                                //생성자 ()안 부분이
class PhoneDialog(val phoneDialog: Context, val name:String) :Dialog(phoneDialog) {
    private val binding by lazy { PhoneDialogBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this

        val span = SpannableString("입력하신 전화번호로 $name 님만의 링크가 도착했어요!\n링크에 접속하여 회원가입을 완료해주세요.")
        span.setSpan(ForegroundColorSpan(Color.parseColor("#F1DE33")), 11,  span.length - 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.dialogContent.text = span

        binding.dialogOkBtn.setOnClickListener {
            dismiss()
        }

    }
}
