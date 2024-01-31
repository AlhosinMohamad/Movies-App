package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.Artist.Artist
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ListItemBinding

class ArtistAdapter:RecyclerView.Adapter<MyArtistViewHolder>() {
    val artistList=ArrayList<Artist>()

    fun setArtistList(artists:List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyArtistViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyArtistViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size

    }

    override fun onBindViewHolder(holder: MyArtistViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}

class MyArtistViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind( artist:Artist){
        binding.titleTextView.text=artist.name
        binding.descriptionTextView.text=artist.popularity.toString()
        val posterURL="https://image.tmdb.org/t/p/w500"+artist.profilePath

        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }

}