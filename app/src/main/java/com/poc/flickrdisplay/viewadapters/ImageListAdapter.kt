package com.poc.flickrdisplay.viewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poc.flickrdisplay.databinding.PhotoItemBinding
import com.poc.flickrdisplay.databinding.PhotoThumbnailItemBinding
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.viewmodels.MainViewModel
import java.util.*
import javax.inject.Inject

class ImageListAdapter @Inject constructor() : RecyclerView.Adapter<ImageViewHolder>() {

    companion object {
        const val MAIN_ROW = 1
        const val THUMBNAIL = 2;
    }

    private var thumbnailRow: Int = 0

    private var data: List<Photo>? = null
    private var mainVm: MainViewModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            THUMBNAIL -> ImageViewHolder(PhotoThumbnailItemBinding.inflate(inflater, parent, false))
            else -> ImageViewHolder(PhotoItemBinding.inflate(inflater, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            thumbnailRow -> THUMBNAIL
            else -> MAIN_ROW
        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        data?.get(position)?.let { holder.bind(it, mainVm) }
    }

    fun populateData(list: List<Photo>?, mainViewModel: MainViewModel?) {
        data = list
        mainVm = mainViewModel
        thumbnailRow = Random().nextInt(itemCount)
        notifyDataSetChanged()
    }
}
