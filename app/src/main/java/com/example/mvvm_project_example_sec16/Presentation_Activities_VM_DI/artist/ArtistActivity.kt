package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ActivityArtistBinding
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel:ArtistViewModel
    private lateinit var binding:ActivityArtistBinding
    private lateinit var adapter:ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_artist)

        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel=ViewModelProvider(this,factory)
            .get(ArtistViewModel::class.java)

        initRecyclerView()

        displayArtistInRecyclerView()
    }

    fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager=LinearLayoutManager(applicationContext)
        adapter= ArtistAdapter()
        binding.artistRecyclerView.adapter=adapter
    }

    fun displayArtistInRecyclerView(){
        binding.artistProgressBar.visibility=View.GONE
        val artistListLiveData=artistViewModel.getArtist()

        artistListLiveData.observe(this, Observer {
            if(it!=null){
               adapter.setArtistList(it)
               adapter.notifyDataSetChanged()
               binding.artistProgressBar.visibility=View.GONE
            }
            else{
                binding.artistProgressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Data Available",Toast.LENGTH_LONG).show()
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
        binding.artistProgressBar.visibility=View.VISIBLE

        val response=artistViewModel.updateArtist()

        response.observe(this, Observer {
            if(it!=null){
                adapter.setArtistList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility=View.GONE
            }else{
                binding.artistProgressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Updated Data",Toast.LENGTH_LONG).show()
            }
        })
    }
}