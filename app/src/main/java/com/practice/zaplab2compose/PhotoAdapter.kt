package com.practice.zaplab2compose

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.practice.zaplab2compose.model.PhotoData
import javax.inject.Inject

class PhotoAdapter @Inject constructor(var photoDataList: List<PhotoData>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoData = photoDataList[position]

        Glide.with(holder.itemView)
            .load(photoData.url)
            .into(holder.image)

        holder.title.text =
            photoDataList[position].id.toString() + " - " + photoDataList[position].title
    }

    override fun getItemCount() = photoDataList.size
}