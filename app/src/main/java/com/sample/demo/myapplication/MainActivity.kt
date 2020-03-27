@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send_data.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                infoViewModel.step1(true)
                infoViewModel.step2(true)
                checkStep3()
            }
        }
    }
    private fun checkStep3(){
        AlertDialog.Builder(this@MainActivity)
            .setTitle("hi")
            .setMessage("choice")
            .setPositiveButton("OK") { _, _ ->
                runBlocking {
                    infoViewModel.step3(true)
                }
            }
            .setNegativeButton("NO") { _, _ ->
                runBlocking {
                    infoViewModel.step3(false)
                }
            }
            .show()
    }
}

