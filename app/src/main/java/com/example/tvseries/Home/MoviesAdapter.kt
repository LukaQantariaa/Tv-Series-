package com.example.tvseries.Home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.tvseries.Details.DetailedActivity
import com.example.tvseries.MoviesModel
import com.example.tvseries.R
import com.squareup.picasso.Picasso

class MoviesAdapter (var mCtx: Context, var resources: Int, var items: Array<MoviesModel>): ArrayAdapter<MoviesModel>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources, null)

        val imageView: ImageView = view.findViewById(R.id.image)
        val textView: TextView = view.findViewById(R.id.text)

        var movieItem: MoviesModel = items[position];
        Picasso.with(this.mCtx).load(movieItem.imageUrl).placeholder(R.drawable.bg_grey).into(imageView)
        textView.text = movieItem.title

        view.setOnClickListener {v: View ->
            val position: Int = position
            println(items[position].title)
            val intent: Intent = Intent(v.context, DetailedActivity::class.java).apply {
                putExtra("id", items[position].id)
            }
            v.context.startActivity(intent)
        }

        return view
    }
}