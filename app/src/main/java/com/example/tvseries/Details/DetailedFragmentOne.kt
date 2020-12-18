package com.example.tvseries.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.tvseries.R
import com.example.tvseries.ViewModels.MainViewModel

private var ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailedFragmentOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("id")
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_one, container, false)
        val txt = view.findViewById<TextView>(R.id.f1txt)
        txt.setText(arguments?.getInt("id", 0).toString())
        return view
    }

}