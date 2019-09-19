package com.poc.flickrdisplay.rx

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RxHelper @Inject constructor() {

    fun <T> singleTransformer(): SingleTransformer<T, T> {
        return SingleTransformer { single -> single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) }
    }
}