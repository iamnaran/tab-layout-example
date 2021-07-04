package com.kuhu.tablayout.main.adapter

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kuhu.tablayout.main.fragments.HomeFragment
import com.kuhu.tablayout.main.fragments.NotificationFragment
import com.kuhu.tablayout.main.fragments.ProfileFragment


class ViewPagerAdapter(fa: FragmentActivity, private val listOfTitle: List<String>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = listOfTitle.size

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return ProfileFragment()
            2 -> return NotificationFragment()
        }
        return HomeFragment()
    }

}