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
import com.example.after_corona.databinding.FragmentHomeBinding
import com.example.after_corona.view.WriteCapsuleActivity
import com.example.after_corona.view.viewmodel.HomeViewModel
import com.example.after_corona.view.viewmodel.TodoViewModel

class HomeFragment : Fragment() {

    lateinit var binding :FragmentHomeBinding
    val viewModel: HomeViewModel by lazy {
        ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.fragment =this
        binding.lifecycleOwner = this
        initializelist()

        viewModel.getUser()

            binding.homeBtn.setOnClickListener {
            val intent = Intent(requireContext(), WriteCapsuleActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    fun goAddCap(){

    }
    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        viewModel.onCoronaEndSuccessEvent.observe(viewLifecycleOwner, Observer {
            binding.openCapsuleFragment.visibility = View.VISIBLE
            binding.writeCapsuleFragment.visibility = View.GONE
        })

        viewModel.onCoronaEndFailureEvent.observe(viewLifecycleOwner, Observer {
            binding.openCapsuleFragment.visibility = View.GONE
            binding.writeCapsuleFragment.visibility = View.VISIBLE
        })




    }

}