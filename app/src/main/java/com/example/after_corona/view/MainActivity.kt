package com.example.after_corona.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.after_corona.R
import com.example.after_corona.databinding.ActivityLinkageSuccessBinding
import com.example.after_corona.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.activity = this


        binding.vp.apply { adapter = ViewPagerAdapter(this@MainActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bn.selectedItemId = when (position) {
                        0 -> R.id.menu_calendar
                        1 -> R.id.menu_home
                        else -> R.id.menu_user
                    }
                }
            })
        }

        binding.bn.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_calendar -> binding.vp.currentItem = 0
                R.id.menu_home -> binding.vp.currentItem = 1
                else -> binding.vp.currentItem = 2 }
            true
        }
    binding.bn.selectedItemId = R.id.menu_home


    }

    inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount() = 3
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> CalendarFragment()
                1 -> HomeFragment()
                else -> UserFragment()
            }

        }

    }

}


