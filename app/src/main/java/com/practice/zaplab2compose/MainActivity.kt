package com.practice.zaplab2compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.zaplab2compose.model.DataRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val photoViewModel: PhotoViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private var photoAdapter = PhotoAdapter(emptyList())

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = photoAdapter

        photoViewModel.getDataFomRepository(DataRepository()).observe(this, Observer { result ->
            result?.let {
                photoAdapter.photoDataList = result
                photoAdapter.notifyDataSetChanged()
            }
        })
    }
}