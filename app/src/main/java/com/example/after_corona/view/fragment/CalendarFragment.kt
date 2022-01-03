package com.example.after_corona.view.fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.after_corona.R
import com.example.after_corona.databinding.FragmentCalendarBinding
import com.example.after_corona.view.LoginActivity
import com.example.after_corona.view.RecyclerViewAdapter
import com.example.after_corona.view.data.GetTodoData
import com.example.after_corona.view.data.ListData
import com.example.after_corona.view.viewmodel.SignupViewModel
import com.example.after_corona.view.viewmodel.TodoViewModel


class CalendarFragment : Fragment() {
    private lateinit var binding: FragmentCalendarBinding
    private lateinit var adapter: RecyclerViewAdapter //adapter객체 먼저 선언해주기!
    val viewModel: TodoViewModel by lazy {
        ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)

    }
    val mDatas = mutableListOf<GetTodoData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializelist()
        Log.d(TAG, "onViewCreated: calender Fragment 호출")
    }


    fun initListRecyclerView() {
        val adapter = RecyclerViewAdapter() //어댑터 객체 만듦
        adapter.datalist = mDatas //데이터 넣어줌
        binding.recyclerView.adapter = adapter //리사이클러뷰에 어댑터 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(context) //레이아웃 매니저 연결
        adapter.notifyDataSetChanged()


    }

    override fun onResume() {
        super.onResume()
        viewModel.getTodo()
    }

    fun initializelist() { //임의로 데이터 넣어서 만들어봄
        viewModel.list.observe(viewLifecycleOwner, Observer{
            mDatas.clear()
            mDatas.addAll(it)
            initListRecyclerView()
        })
        }

        }



