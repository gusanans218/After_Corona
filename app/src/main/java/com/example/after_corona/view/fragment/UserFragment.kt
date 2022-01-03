package com.example.after_corona.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.after_corona.R
import com.example.after_corona.databinding.FragmentUserBinding
import com.example.after_corona.view.PrivacyActivity
import com.example.after_corona.view.data.Constant
import com.example.after_corona.view.viewmodel.HomeViewModel
import com.example.after_corona.view.viewmodel.UserViewModel


class UserFragment : Fragment()  {

    lateinit var binding : FragmentUserBinding
    val viewModel: UserViewModel by lazy {
        ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

    }


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
        initializelist()
        viewModel.getUser(Constant.id)
        return binding.root
    }


    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        viewModel.userData.observe(viewLifecycleOwner, Observer {
            binding.userUsername.text = it.name
            binding.userEmail.text = it.id

        })



    }
}