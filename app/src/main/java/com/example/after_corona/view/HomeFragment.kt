package com.example.after_corona.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.after_corona.R
import com.example.after_corona.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding :FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.fragment =this
        binding.lifecycleOwner = this

        binding.homeBtn.setOnClickListener {
            val intent = Intent(requireContext(), WriteCapsuleActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    fun goAddCap(){

    }

}