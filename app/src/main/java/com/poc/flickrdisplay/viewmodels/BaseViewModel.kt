package com.poc.flickrdisplay.viewmodels

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : LifecycleObserver {
    private val lifeCycleSubscriptions: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        lifeCycleSubscriptions.clear()
    }

    protected fun subsribeOnLifeCycle(disposable: Disposable) {
        lifeCycleSubscriptions.add(disposable)
    }
}