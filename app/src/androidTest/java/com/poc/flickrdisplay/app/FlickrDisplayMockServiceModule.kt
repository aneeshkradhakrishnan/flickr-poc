package com.poc.flickrdisplay.app

import com.poc.flickrdisplay.service.FlickrMockService
import com.poc.flickrdisplay.service.FlickrService
import dagger.Provides

class FlickrDisplayMockServiceModule : FlickrDisplayServiceModule() {

    @Provides
    override fun provideFlickrService(): FlickrService {
        return FlickrMockService()
    }
}