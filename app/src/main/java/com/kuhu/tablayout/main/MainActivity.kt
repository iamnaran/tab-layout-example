package com.kuhu.tablayout.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kuhu.tablayout.R
import com.kuhu.tablayout.main.adapter.PagerAdapter
import com.kuhu.tablayout.main.adapter.ViewPagerAdapter


class MainActivity : AppCompatActivity() {


    private lateinit var googleTabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var badgeTabLayout: TabLayout
    private lateinit var iconBadgeTabLayout: TabLayout

    private val listOfTitles = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_layout)
        googleTabLayout = findViewById(R.id.google_tab_layout)
        badgeTabLayout = findViewById(R.id.badge_tab_layout)
        viewPager = findViewById(R.id.view_pager)
        iconBadgeTabLayout = findViewById(R.id.icon_badge_tab_layout)
        loadTitles()
        setUpBadgeForTabLayout()
        setUpIconWithBadgeForTabLayout()
        setUpViewPagerWithTabLayout()
//        setUpPagerTabLayout()
        addTabLayoutMediator()

    }


    private fun loadTitles() {

        listOfTitles.add("Home")
        listOfTitles.add("Profile")
        listOfTitles.add("Notification")
        listOfTitles.add("Activity")
        listOfTitles.add("Timeline")
    }


    private fun setUpViewPagerWithTabLayout() {
        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ViewPagerAdapter(this, listOfTitles)
        viewPager.adapter = pagerAdapter
        addTabLayoutMediator()

    }

    private fun setUpPagerTabLayout() {

        val viewPagerSingleAdapter = PagerAdapter(this,listOfTitles)
        viewPager.adapter = viewPagerSingleAdapter
        addTabLayoutMediator()

    }

    private fun addTabLayoutMediator() {

        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = listOfTitles[position]
        }.attach()
    }


    private fun setUpBadgeForTabLayout() {
        //set the badge
        val badgeDrawable = badgeTabLayout.getTabAt(0)!!.orCreateBadge
        badgeDrawable.isVisible = true
        badgeDrawable.number = 5
    }

    private fun setUpIconWithBadgeForTabLayout() {
        //set the badge
        val badgeDrawable = iconBadgeTabLayout.getTabAt(0)!!.orCreateBadge
        badgeDrawable.isVisible = true
        badgeDrawable.number = 8
    }

}