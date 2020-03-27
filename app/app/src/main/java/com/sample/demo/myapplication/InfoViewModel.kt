package com.sample.demo.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InfoViewModel(application: Application, var infoRepository: InfoRepository) : ViewModel() {
    suspend fun step1(isSuccess: Boolean) = withContext(Dispatchers.IO) {
        if (isSuccess) {
            Log.d("rick", "step1")
        } else {
            Log.d("rick", "step1 nothing")
        }
    }

    suspend fun step2(isSuccess: Boolean) = withContext(Dispatchers.IO) {
        if (isSuccess) {
            Log.d("rick", "step2")
        } else {
            Log.d("rick", "step2 nothing")
        }
    }

    suspend fun step3(isSuccess: Boolean) = withContext(Dispatchers.IO) {
        if (isSuccess) {
            Log.d("rick", "step3")
        } else {
            Log.d("rick", "step3 nothing")
        }
    }
}