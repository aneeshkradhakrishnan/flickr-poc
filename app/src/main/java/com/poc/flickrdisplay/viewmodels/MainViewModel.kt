package com.poc.flickrdisplay.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.DividerItemDecoration
import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.model.PhotoResponse
import com.poc.flickrdisplay.rx.RxHelper
import com.poc.flickrdisplay.service.FlickrService
import com.poc.flickrdisplay.viewadapters.ImageListAdapter
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var adapter: ImageListAdapter
    @Inject
    lateinit var flickrService: FlickrService
    @Inject
    lateinit var rxHelper: RxHelper

    lateinit var startImageDetailsActivity: (photo: Photo) -> Unit
    lateinit var itemDivider: DividerItemDecoration

    val title: ObservableField<String> = ObservableField()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun fetchPhotoList() {
        subsribeOnLifeCycle(flickrService.getPhotos()
                .compose(rxHelper.singleTransformer())
                .subscribe(this::populatePhoto, this::errorFetchingPhotos))
    }

    fun itemClicked(photo: Photo) {
        startImageDetailsActivity(photo)
    }

    private fun populatePhoto(photoResponse: PhotoResponse) {
        if(photoResponse?.status == "fail") {
            title.set("Code : ${photoResponse.code} - ${photoResponse.message}")
            return
        }
        adapter.populateData(photoResponse.photoPage?.photos, this)
    }

    private fun errorFetchingPhotos(e: Throwable) {
        e.printStackTrace()
        title.set("Exception Fetching Photos : ${e.javaClass.simpleName} - ${e.message}")
    }
}