package com.example.tvseries.Details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.tvseries.Home.MoviesAdapter
import com.example.tvseries.R
import com.example.tvseries.ViewModels.MainViewModel
import com.google.android.material.tabs.TabLayout

class DetailedActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)


        val id: Int = intent.getIntExtra("id", 1)


        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        var fragmentAdapter = DetailedPagerAdapter(supportFragmentManager, id);
        viewPager.adapter = fragmentAdapter;
        tabLayout.setupWithViewPager(viewPager)

    }

//    fun back(view: View) {
//        onBackPressed()
//    }
}