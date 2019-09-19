package com.poc.flickrdisplay.service

import com.poc.flickrdisplay.model.PhotoResponse
import com.poc.flickrdisplay.util.PhotoUtil
import io.reactivex.Single

//This is an easy go
//it should be done with mock webserver and dispatching the json matching request
class FlickrMockService : FlickrService {
    override fun getPhotos(pageSize: Int, apiKey: String, method: String, format: String, noJsonCallBack: Int): Single<PhotoResponse> {
        return Single.just(PhotoUtil.createPhotoResponse(10))
    }
}