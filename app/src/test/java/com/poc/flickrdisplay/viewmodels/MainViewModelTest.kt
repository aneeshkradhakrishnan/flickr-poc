package com.poc.flickrdisplay.viewmodels

import com.poc.flickrdisplay.model.Photo
import com.poc.flickrdisplay.model.PhotoPage
import com.poc.flickrdisplay.model.PhotoResponse
import com.poc.flickrdisplay.rx.RxHelper
import com.poc.flickrdisplay.service.FlickrService
import com.poc.flickrdisplay.viewadapters.ImageListAdapter
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verifyAll
import io.reactivex.Single
import io.reactivex.SingleTransformer
import org.junit.Test

class MainViewModelTest : BaseKTest() {

    @RelaxedMockK
    lateinit var adpter: ImageListAdapter

    @RelaxedMockK
    lateinit var flickrService: FlickrService

    @MockK
    lateinit var rxHelper: RxHelper

    @InjectMockKs
    var subject = MainViewModel()

    @Test
    fun fetchList_setsData() {
        var photo: Photo = mockk()
        var photoPage: PhotoPage = mockk()
        var photoResponse: PhotoResponse = mockk()
        every { photoPage.photos } returns listOf(photo)
        every { photoResponse.photoPage } returns photoPage
        every { flickrService.getPhotos() } returns Single.just(photoResponse)
        every { rxHelper.singleTransformer<Any>() } returns SingleTransformer { s -> s }

        subject.fetchPhotoList()

        verifyAll { adpter.populateData(listOf(photo), subject) }
    }

    @Test
    fun itemClicked_opensImageDetails() {
        var listenerStartActivity: (photo: Photo) -> Unit = mockk()
        var photo: Photo = mockk()
        every { listenerStartActivity(photo) } returns Unit

        subject.startImageDetailsActivity = listenerStartActivity
        subject.itemClicked(photo)
        verifyAll { listenerStartActivity(photo) }
    }
}