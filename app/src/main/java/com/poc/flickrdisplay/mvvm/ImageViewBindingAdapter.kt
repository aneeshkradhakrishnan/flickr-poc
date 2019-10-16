package com.poc.flickrdisplay.mvvm

import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.poc.flickrdisplay.R
import com.poc.flickrdisplay.customviews.CollapsibleText
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.util.PhotoSize
import com.squareup.picasso.Picasso

class ImageViewBindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("flickr", "photoSize")
        fun setImageViewResource(imageView: ImageView, photo: Photo?, photoSize: PhotoSize) {
            photo?.let { it ->
                Picasso.get()
                        .load("https://farm${photo.farm}.staticflickr.com/" +
                                "${photo.server}/${photo.id}_${photo.secret}_${photoSize.value}.png")
                        .error(R.drawable.ic_photo)
                        .into(imageView)
            }
        }

        @JvmStatic
        @BindingAdapter("collapseOrientation")
        fun setImageViewResource(textView: CollapsibleText, collapseOrientation: Int) {
            textView.collapseOrientation = collapseOrientation;
        }
    }
}