package com.example.after_corona.view

import android.app.Dialog
import android.bluetooth.BluetoothClass
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.after_corona.R
import com.example.after_corona.databinding.MyDialogBinding
import kotlin.math.log

class DeviceDialog (context : Context):Dialog(context){


    private val binding : MyDialogBinding by lazy { MyDialogBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }





}

