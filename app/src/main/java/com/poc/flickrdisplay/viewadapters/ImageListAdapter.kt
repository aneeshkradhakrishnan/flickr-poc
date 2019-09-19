package com.poc.flickrdisplay.viewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poc.flickrdisplay.databinding.PhotoItemBinding
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.viewmodels.MainViewModel
import javax.inject.Inject

class ImageListAdapter @Inject constructor() : RecyclerView.Adapter<ImageViewHolder>() {

    private var data: List<Photo>? = null
    private var mainVm: MainViewModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ImageViewHolder(PhotoItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        data?.get(position)?.let { holder.bind(it, mainVm) }
    }

    fun populateData(list: List<Photo>?, mainViewModel: MainViewModel?) {
        data = list
        mainVm = mainViewModel
        notifyDataSetChanged()
    }
}
