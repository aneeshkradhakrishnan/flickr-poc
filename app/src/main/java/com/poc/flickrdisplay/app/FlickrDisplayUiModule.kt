package com.poc.flickrdisplay.app

import com.poc.flickrdisplay.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FlickrDisplayUiModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}
