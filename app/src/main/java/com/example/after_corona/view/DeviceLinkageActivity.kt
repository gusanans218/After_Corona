package com.example.after_corona.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityDeviceLinkageBinding
import com.example.after_corona.databinding.ActivityLoginBinding

class DeviceLinkageActivity : AppCompatActivity(),View.OnClickListener {
    private val binding by lazy { ActivityDeviceLinkageBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this


        binding.deviceBtn.setOnClickListener (this)

    }


    override fun onClick(v: View) {
        when(v?.id) {
            binding.deviceBtn.id -> {
                val dlg = DeviceDialog(this)
                dlg.show()
            }
        }
    }
}