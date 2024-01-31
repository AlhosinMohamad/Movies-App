package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Movie.Movie
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ListItemBinding

class MovieAdapter():RecyclerView.Adapter<MyMovieViewHolder>() {
    private val movielist=ArrayList<Movie>()

    fun setList(movies:List<Movie>){
        movielist.clear()
        movielist.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieViewHolder {
       val layoutInflator=LayoutInflater.from(parent.context)
        val binding:ListItemBinding =DataBindingUtil.inflate(
            layoutInflator,
            R.layout.list_item,
            parent,
            false
        )

        return MyMovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return movielist.size
    }

    override fun onBindViewHolder(holder: MyMovieViewHolder, position: Int) {
       holder.bind(movielist[position])
    }
}

 class MyMovieViewHolder(val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie){
        binding.titleTextView.text=movie.title
        binding.descriptionTextView.text=movie.overview
        val poster="https://image.tmdb.org/t/p/w500"+movie.posterPath

        //Glide Library
        Glide.with(binding.imageView.context)
            .load(poster)
            .into(binding.imageView)

    }
}