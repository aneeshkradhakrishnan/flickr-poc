package com.poc.flickrdisplay.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(

        @SerializedName("photos")
        val photoPage: PhotoPage?,

        @SerializedName("stat")
        val status: String?,

        @SerializedName("code")
        val code: Int?,

        @SerializedName("message")
        val message: String?
)
