package com.example.tvseries.Details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.tvseries.R
import com.example.tvseries.ViewModels.MainViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailedFragmentTwo : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_two, container, false)

        val listView = view.findViewById<ListView>(R.id.listView)

        val detailedId = arguments?.getInt("id", 0)

        val mainViewModel = MainViewModel()

        mainViewModel.movieDetailedLiveData.observe(
                viewLifecycleOwner,
                Observer {
                    listView.adapter = CastAdapter(view.context, R.layout.cast_row, it.cast)
                }
        )

        if(detailedId != null) {
            mainViewModel.getMovie(detailedId)
        }

        return view
    }

}