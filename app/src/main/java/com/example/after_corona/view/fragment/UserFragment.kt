package com.example.after_corona.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.after_corona.R
import com.example.after_corona.databinding.FragmentUserBinding
import com.example.after_corona.view.PrivacyActivity


class UserFragment : Fragment() {

    lateinit var binding : FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user,container,false)
        binding.fragment =this
        binding.lifecycleOwner = this

        binding.userBtn4.setOnClickListener {
            val intent = Intent(requireContext(), PrivacyActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }


}