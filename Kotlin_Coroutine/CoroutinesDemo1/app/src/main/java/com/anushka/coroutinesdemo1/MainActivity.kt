package com.anushka.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                //downloadUserData()

                /*utk unstructured concurrency*/
                //tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
                /*utk structured concurrency*/
                tvUserMessage.text = UserDataManager2().getTotalUserCount().toString()

            }

        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            //Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            withContext(Dispatchers.Main){
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
            delay(3000)
        }
    }
}
