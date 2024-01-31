package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.databinding.DataBindingUtil
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist.ArtistActivity
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie.MovieActivity
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows.TvShowActivity
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnMovies.setOnClickListener {
            val intent= Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }

        binding.btnTvshows.setOnClickListener {
            val intent=Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.btnArtist.setOnClickListener {
            val intent=Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }
}