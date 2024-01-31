package com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.webkit.WebSettings.LayoutAlgorithm
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.Injector
import com.example.mvvm_project_example_sec16.Presentation_Activities_VM_DI.di.movie.MovieSubComponent
import com.example.mvvm_project_example_sec16.R
import com.example.mvvm_project_example_sec16.databinding.ActivityMovieBinding
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var moviewViewModel: MovieViewModel
    private lateinit var binding:ActivityMovieBinding
    private lateinit var adapter:MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)

        moviewViewModel=ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)

        initRecyclerView()

        displayPopularMovie()

    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter=MovieAdapter()
        binding.movieRecyclerView.adapter=adapter
    }

    fun displayPopularMovie(){
        binding.movieProgressBar.visibility= View.VISIBLE
        val responseLiveData=moviewViewModel.getMovies()

        responseLiveData.observe(this, Observer {
            Log.i("MyTag",it.toString())
           if(it!=null){
               adapter.setList(it)
               adapter.notifyDataSetChanged()
               binding.movieProgressBar.visibility= View.GONE
           }
            else{
               binding.movieProgressBar.visibility= View.GONE
               Toast.makeText(applicationContext,"No Data available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i("onCreateOptionsMenu","onCreateOptionsMenu is called")
        val inflater:MenuInflater=menuInflater
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
        binding.movieProgressBar.visibility=View.VISIBLE

        val response=moviewViewModel.updatMovies()

        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility=View.GONE
            }else{
                binding.movieProgressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Updated Data",Toast.LENGTH_LONG).show()
            }
        })
    }


}