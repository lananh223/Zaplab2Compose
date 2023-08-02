package com.practice.zaplab2compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.zaplab2compose.model.DataRepository

class MainActivity : ComponentActivity() {

    private val photoViewModel: PhotoViewModel by lazy {
        ViewModelProvider(this)[PhotoViewModel::class.java]
    }

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