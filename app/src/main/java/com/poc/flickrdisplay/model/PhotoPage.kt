package com.poc.flickrdisplay.model

import com.google.gson.annotations.SerializedName

data class PhotoPage(

        @SerializedName("page")
        val pageNumber: Int?,

        @SerializedName("pages")
        val totalPages: Int?,

        @SerializedName("perpage")
        val photosPerPage: Int?,

        @SerializedName("total")
        val totalPhotos: Int?,

        @SerializedName("photo")
        val photos: List<Photo>?
)

