package com.example.learnworkmanagernewapp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(context: Context, params:WorkerParameters): Worker(context,params) {
    override fun doWork(): Result {
        try {
            for (i in 0..60000){
                Log.i("MYTAG","Uploading $i")
            }
            return Result.success()
        }catch (e:Exception){
            return Result.failure()
        }
    }
}