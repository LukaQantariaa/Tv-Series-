package com.example.tvseries

class MoviesModel (
    val id: Int,
    val title: String,
    val date: String,
    val language: String,
    val seasons: Number,
    val imageUrl: String,
    val cast: Array<CastsModel>
) {
}