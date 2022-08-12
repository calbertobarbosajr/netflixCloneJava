package com.example.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixclone.Adapter.MoviesAdapter
import com.example.netflixclone.databinding.ActivityMovieDetailsBinding
import com.example.netflixclone.list.addMovies
import com.squareup.picasso.Picasso

class MovieDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        val recycler_other_movies = binding.recyclerOtherMovies
        recycler_other_movies.adapter = MoviesAdapter(addMovies())
        recycler_other_movies.layoutManager = GridLayoutManager(applicationContext,3)

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-89b12.appspot.com/o/video.jpg?alt=media&token=6b169f92-accb-4986-92f9-5dd53a02fd9c"
        Picasso.get().load(capaTheWitcher).fit().into(binding.capa)

        binding.playVideo.setOnClickListener {
            val intent = Intent(this,Video::class.java)
            startActivity(intent)
        }

    }


    private fun Toolbar(){
        val toolbar_details = binding.toolbarDetails
        toolbar_details.setNavigationIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24))
        toolbar_details.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}