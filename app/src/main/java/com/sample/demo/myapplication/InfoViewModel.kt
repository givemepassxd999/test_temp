package com.sample.demo.myapplication

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoViewModel(application: Application, var infoRepository: InfoRepository) : AndroidViewModel(application) {

    val testLiveData = MutableLiveData<Boolean>()
    @SuppressLint("CheckResult")
    fun test(owner: LifecycleOwner, callback: LiveData<Boolean>) {
        Observable.just(1)
            .subscribeOn(Schedulers.newThread())
            .map {
                Log.d("rick", "a")
                it
            }
            .map {
                Log.d("rick", "b")
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                testLiveData.value = true
                callback.observe(owner, Observer {
                    //do something
                    if(it) {
                        Log.d("rick", "c")
                    } else{
                        Log.d("rick", "nothing")
                    }
                })
            }
    }
}