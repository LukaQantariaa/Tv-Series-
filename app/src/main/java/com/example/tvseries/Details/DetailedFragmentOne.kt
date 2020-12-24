package com.example.tvseries.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.tvseries.Home.MoviesAdapter
import com.example.tvseries.R
import com.example.tvseries.ViewModels.MainViewModel
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

private var ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DetailedFragmentOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("id")
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_one, container, false)
        val title = view.findViewById<TextView>(R.id.title)
        val date = view.findViewById<TextView>(R.id.date)
        val language = view.findViewById<TextView>(R.id.language)
        val seasons = view.findViewById<TextView>(R.id.seasons)
        val imageView: ImageView = view.findViewById<ImageView>(R.id.movieImage)


        val mainViewModel = MainViewModel()
        val detailedId = arguments?.getInt("id", 0)

        mainViewModel.movieDetailedLiveData.observe(
                viewLifecycleOwner,
                Observer {
                    Picasso.with(context).load(it.imageUrl).placeholder(R.drawable.bg_grey).into(imageView)
                    title.setText(it.title)
                    date.setText(it.date)
                    language.setText(it.language)
                    seasons.setText(it.seasons.toString())
                }
        )

        if(detailedId != null) {
            mainViewModel.getMovie(detailedId)
        }

        return view
    }

}