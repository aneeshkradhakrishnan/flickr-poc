package com.poc.flickrdisplay.util

import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.model.PhotoPage
import com.poc.flickrdisplay.model.PhotoResponse

object PhotoUtil {
    fun createPhoto(index: Int): Photo {
        return Photo("548917-id-${index}",
                "owner-${index}",
                "secret-${index}",
                "server-4b92-${index}",
                index,
                "I‘m With Cupid $index Graphic Tee")
    }

    fun createPhotoPage(num: Int): PhotoPage {
        var list: MutableList<Photo> = mutableListOf()
        for (x in 0 until num) {
            list.add(createPhoto(x))
        }

        return PhotoPage(1, 25, 20, 500, list)
    }

    fun createPhotoResponse(num: Int): PhotoResponse {
        return PhotoResponse(createPhotoPage(num), "StatusOK", null, null)
    }
}