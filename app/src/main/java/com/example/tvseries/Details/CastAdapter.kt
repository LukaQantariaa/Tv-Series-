package com.example.tvseries.Details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tvseries.CastsModel
import com.example.tvseries.MoviesModel
import com.example.tvseries.R
import com.squareup.picasso.Picasso

class CastAdapter(var mCtx: Context, var resources: Int, var items: Array<CastsModel>): ArrayAdapter<CastsModel>(mCtx, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resources, null)

        val imageView: ImageView = view.findViewById(R.id.cast_image)
        val textOne: TextView = view.findViewById(R.id.cast_text_one)
        val textTwo: TextView = view.findViewById(R.id.cast_text_two)

        var castItem: CastsModel = items[position];
        Picasso.with(this.mCtx).load(castItem.imageUrl).placeholder(R.drawable.bg_grey).into(imageView)
        textOne.setText(castItem.fullName)
        textTwo.setText(castItem.role)



        return view
    }
}