@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()
    private val data = MutableLiveData<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send_data.setOnClickListener {
            infoViewModel.test(this, data)
        }

        infoViewModel.testLiveData.observe(this, Observer {
            if (it) {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("hi")
                    .setMessage("choice")
                    .setPositiveButton("OK") { _, _ -> data.value = true }
                    .setNegativeButton("NO") { _, _ -> data.value = false }
                    .show()
            }
        })
    }
}
