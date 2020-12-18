package com.example.tvseries.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.tvseries.R
import com.example.tvseries.ViewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val listView = findViewById<ListView>(R.id.listView)

        //View Model
        val mainViewModel = MainViewModel()

        Toast.makeText(this, "it.movies.size", Toast.LENGTH_SHORT).show()

        mainViewModel.moviesLiveData.observe(
            this,
            Observer {
                Toast.makeText(this, it.movies.size, Toast.LENGTH_SHORT).show()
                listView.adapter = MoviesAdapter(this, R.layout.movies_row, it.movies)
            }
        )

        mainViewModel.getMovies();


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}