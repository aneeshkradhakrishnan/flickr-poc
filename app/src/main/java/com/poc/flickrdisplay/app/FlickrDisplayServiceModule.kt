package com.poc.flickrdisplay.app

import com.google.gson.GsonBuilder
import com.poc.flickrdisplay.service.FlickrService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
open class FlickrDisplayServiceModule {

    companion object {
        const val FLICKR_HOST = "https://www.flickr.com/"
    }

    @Provides
    open fun provideFlickrService(): FlickrService {

        val logging = HttpLoggingInterceptor()
        logging.level = BASIC

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(FLICKR_HOST)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(FlickrService::class.java)
    }
}
