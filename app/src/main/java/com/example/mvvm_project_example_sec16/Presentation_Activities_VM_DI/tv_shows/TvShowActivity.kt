package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.tv_shows

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.Injector
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie.MovieViewModel
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie.MovieViewModelFactory
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ActivityArtistBinding
import com.example.mvvm_project_example_sec16.databinding.ActivityTvShowBinding
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvshowViewModel
    private lateinit var binding:ActivityTvShowBinding
    private lateinit var adapter:TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel=ViewModelProvider(this,factory)
            .get(TvshowViewModel::class.java)

        initRecyclerViewTvShow()

        displayPopularTvShow()
    }

    fun initRecyclerViewTvShow(){
        binding.recyclerView.layoutManager=LinearLayoutManager(applicationContext)
        adapter= TvShowAdapter()
        binding.recyclerView.adapter=adapter
    }

    fun displayPopularTvShow(){
        binding.tvShowprogressBar.visibility= View.VISIBLE
        val responseLiveData=tvShowViewModel.getTvShows()

        responseLiveData.observe(this, Observer {
            Log.i("MyTag",it.toString())
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowprogressBar.visibility= View.GONE
            }
            else{
                binding.tvShowprogressBar.visibility= View.GONE
                Toast.makeText(applicationContext,"No Data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.action_update->{
                updateMovie()
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }


    private fun updateMovie(){
        binding.tvShowprogressBar.visibility=View.VISIBLE

        val response=tvShowViewModel.updateTvShow()

        response.observe(this, Observer {
            if(it!=null){

                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowprogressBar.visibility=View.GONE
            }else{
                binding.tvShowprogressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Updated Data",Toast.LENGTH_LONG).show()
            }
        })
    }

}