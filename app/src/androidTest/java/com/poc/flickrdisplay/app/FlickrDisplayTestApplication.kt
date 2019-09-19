package com.poc.flickrdisplay.app

import dagger.android.AndroidInjector

class FlickrDisplayTestApplication : FlickrDisplayApplication() {

    override fun applicationInjector(): AndroidInjector<FlickrDisplayApplication> {
        return DaggerFlickrDisplayComponent
                .builder()
                .flickrDisplayServiceModule(FlickrDisplayMockServiceModule())
                .build()
    }
}
