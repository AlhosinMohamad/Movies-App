package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_project_example_sec16.DataLayer_Api_Models_DB_implementRepositories.models.TvShow.TV_Show
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ListItemBinding

class TvShowAdapter() :RecyclerView.Adapter<MyTvShowViewHolder>() {
   private val tvShowList=ArrayList<TV_Show>()

    fun setList(tvshows:List<TV_Show>){
        tvShowList.clear()
        tvShowList.addAll(tvshows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTvShowViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding= DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return MyTvShowViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: MyTvShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}

class MyTvShowViewHolder (val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TV_Show){
        binding.titleTextView.text=tvShow.name
        binding.descriptionTextView.text=tvShow.overview

        val posterURl="https://image.tmdb.org/t/p/w500"+tvShow.posterPath

        Glide.with(binding.imageView.context)
            .load(posterURl)
            .into(binding.imageView)
    }
}