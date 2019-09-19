package com.poc.flickrdisplay.app

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class FlickrDisplayApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<FlickrDisplayApplication> {
        return DaggerFlickrDisplayComponent.builder().build()
    }
}
