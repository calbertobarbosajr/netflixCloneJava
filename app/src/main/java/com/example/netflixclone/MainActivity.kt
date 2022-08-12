package com.example.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netflixclone.Adapter.MoviesAdapter
import com.example.netflixclone.databinding.ActivityMainBinding
import com.example.netflixclone.list.OnItemClickListener
import com.example.netflixclone.list.addMovies
import com.example.netflixclone.list.addOnItemClickListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_movies = binding.recyclerview
        recycler_movies.adapter = MoviesAdapter(addMovies())
        recycler_movies.layoutManager = GridLayoutManager(applicationContext,3)

        recycler_movies.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                when{
                    position == 0 -> movieDetails()
                }
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                loginScreen()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun loginScreen(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }



    private fun movieDetails(){
        val intent = Intent(this,MovieDetails::class.java)
        startActivity(intent)
    }


}