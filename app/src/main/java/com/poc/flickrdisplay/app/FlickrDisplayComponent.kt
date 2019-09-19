package com.poc.flickrdisplay.app

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    FlickrDisplayServiceModule::class,
    FlickrDisplayUiModule::class])
interface FlickrDisplayComponent : AndroidInjector<FlickrDisplayApplication>
