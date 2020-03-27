package com.sample.demo.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InfoViewModel() : ViewModel() {
    interface JobStatus {
        fun jobDone(result: Boolean)
    }

    fun exeTask(): JobStatus {
        viewModelScope.launch(Dispatchers.Main) {
            step1()
            step2()
        }
        return object : JobStatus {
            override fun jobDone(result: Boolean) {
                viewModelScope.launch {
                    step3(result)
                }
            }
        }
    }

    private suspend fun step1() = withContext(Dispatchers.IO) {
        Log.d("rick", "step1")
    }

    private suspend fun step2() = withContext(Dispatchers.IO) {
        Log.d("rick", "step2")
    }

    private suspend fun step3(isSuccess: Boolean) = withContext(Dispatchers.IO) {
        if (isSuccess) {
            Log.d("rick", "step3")
        } else {
            Log.d("rick", "step3 nothing")
        }
    }
}