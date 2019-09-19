package com.poc.flickrdisplay.service

import com.poc.flickrdisplay.model.PhotoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {

    /***
     * Example URL
     * https://www.flickr.com/services/rest/?method=flickr.photos.getRecent&
     * api_key=bf974b65cf9d3486347aa893f2f9f8bf&per_page=20&format=json
     *
     * api_key is valid only for few hrs, if the service return errors use a new api_key
     * use https://www.flickr.com/services/api/explore/flickr.photos.getRecent
     * and generate with 'Do not Sign call'
     */
    @GET("services/rest")
    fun getPhotos(@Query("per_page") pageSize: Int = 25,
                  @Query("api_key") apiKey: String = "27301a31e924417bdff3688919ae16d8",
                  @Query("method") method: String = "flickr.photos.getRecent",
                  @Query("format") format: String = "json",
                  @Query("nojsoncallback") noJsonCallBack: Int = 1): Single<PhotoResponse>
}