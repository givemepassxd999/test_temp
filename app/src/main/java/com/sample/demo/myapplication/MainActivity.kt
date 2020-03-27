@file:Suppress("DEPRECATION")

package com.sample.demo.myapplication

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val infoViewModel: InfoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send_data.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                checkStep3(infoViewModel.exeTask())
            }
        }
    }

    private fun checkStep3(job: InfoViewModel.JobStatus) {
        AlertDialog.Builder(this@MainActivity)
            .setTitle("hi")
            .setMessage("choice")
            .setPositiveButton("OK") { _, _ ->
                job.jobDone(true)
            }
            .setNegativeButton("NO") { _, _ ->
                job.jobDone(false)
            }
            .show()
    }
}

