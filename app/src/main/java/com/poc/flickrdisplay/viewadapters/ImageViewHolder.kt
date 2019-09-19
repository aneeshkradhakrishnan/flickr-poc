package com.poc.flickrdisplay.viewadapters

import androidx.recyclerview.widget.RecyclerView
import com.poc.flickrdisplay.databinding.PhotoItemBinding
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.viewmodels.MainViewModel

class ImageViewHolder(private val itemBinding: PhotoItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

    init {
        itemBinding?.executePendingBindings()
    }

    fun bind(photo: Photo, mainVm: MainViewModel?) {
        itemBinding?.photo = photo
        itemBinding?.mainVm = mainVm
    }
}