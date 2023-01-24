package com.example.appdedoc.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdedoc.DogDetailsActivity
import com.example.appdedoc.DogDetailsActivity.Companion.DOG_KEY
import com.example.appdedoc.api.ApiResponseStatus
import com.example.appdedoc.databinding.ActivityDogListBinding

private const val GRID_SPAN_COUNT = 3

class DogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogListBinding
    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingProgress = binding.loadProgress
        val recycler = binding.recyclerDogList
        recycler.layoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)
        val adapter = DogAdapter()
        adapter.setOnItemClickListener {
            //pasamos el dog a DogDetailsActivity, pero para pasar un objeto entre activity este debe de ser
            //aparcelable, para ello utilizamos un plugin
            val intent = Intent(this, DogDetailsActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }
        recycler.adapter = adapter

        dogListViewModel.dogList.observe(this){ doglist->
            adapter.submitList(doglist)
        }

        dogListViewModel.status.observe(this){ dowloandSatus ->

            when(dowloandSatus) {
                is ApiResponseStatus.ERROR -> {
                    loadingProgress.visibility = View.GONE
                    Toast.makeText(this, dowloandSatus.messageId, Toast.LENGTH_LONG).show()
                }
                is ApiResponseStatus.LOADING -> {
                    loadingProgress.visibility = View.VISIBLE
                }
                is ApiResponseStatus.SUCCESS -> {
                    loadingProgress.visibility = View.GONE
                }
            }
           /* }
            when(dowloandSatus){
                ApiResponseStatus.LOADING -> loadingProgress.visibility = View.VISIBLE//
                ApiResponseStatus.SUCCESS ->{
                    loadingProgress.visibility = View.GONE
                }
                ApiResponseStatus.ERROR -> {
                    loadingProgress.visibility = View.GONE
                    Toast.makeText(this, "Error al optener la lista de perros", Toast.LENGTH_LONG).show()
                }
                else -> {
                    //ocultar progres bar
                    Toast.makeText(this, "Error desconocido", Toast.LENGTH_LONG).show()
                }
            }*/
        }

    }
}