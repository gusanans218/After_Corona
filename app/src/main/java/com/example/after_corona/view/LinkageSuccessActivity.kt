package com.example.after_corona.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityLinkageSuccessBinding
import com.example.after_corona.databinding.ActivityLoginBinding

class LinkageSuccessActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLinkageSuccessBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this

        val ssb =
            SpannableStringBuilder("Time Capsule 디바이스가 연동되었습니다!")
        ssb.apply {
            setSpan(ForegroundColorSpan(Color.BLUE), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


        }
    }
}