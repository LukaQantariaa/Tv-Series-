package com.example.tvseries.Details

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class DetailedPagerAdapter (fm: FragmentManager, val id: Int): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val bunddle = Bundle()
        bunddle.putInt("id", id)
        return when (position) {
            0-> {
                DetailedFragmentOne().apply { arguments = bunddle }
            }
            1-> {
                DetailedFragmentTwo().apply { arguments = bunddle }
            }
            else -> {
                return DetailedFragmentOne().apply { arguments = bunddle }
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0-> "INFO"
            1-> "CAST"
            else -> {
                return "INFO"
            }
        }
    }
}