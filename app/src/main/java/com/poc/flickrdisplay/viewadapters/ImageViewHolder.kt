package com.poc.flickrdisplay.viewadapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.poc.flickrdisplay.databinding.PhotoItemBinding
import com.poc.flickrdisplay.databinding.PhotoThumbnailItemBinding
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.viewmodels.MainViewModel

class ImageViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

    var itemBinding: PhotoItemBinding? = null
    var itemThumbnailItemBinding: PhotoThumbnailItemBinding? = null

    constructor(itemBinding: PhotoItemBinding) : this(itemBinding.root) {
        this.itemBinding = itemBinding
    }

    constructor(itemThumbnailItemBinding: PhotoThumbnailItemBinding) : this(itemThumbnailItemBinding.root) {
        this.itemThumbnailItemBinding = itemThumbnailItemBinding
    }

    init {
        itemBinding?.executePendingBindings()
        itemThumbnailItemBinding?.executePendingBindings()
    }

    fun bind(photo: Photo, mainVm: MainViewModel?) {
        itemBinding?.photo = photo
        itemBinding?.mainVm = mainVm
        itemThumbnailItemBinding?.photo = photo
        itemThumbnailItemBinding?.mainVm = mainVm
    }
}