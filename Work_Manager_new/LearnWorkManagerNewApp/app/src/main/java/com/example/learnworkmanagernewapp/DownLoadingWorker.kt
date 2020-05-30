package com.example.learnworkmanagernewapp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class DownLoadingWorker (context: Context, params: WorkerParameters): Worker(context,params){
    override fun doWork(): Result {
        try {

            for (i in 0 ..3000){
                Log.i("MYTAG","DownLoading $i")
            }

            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate =time.format(Date())
            Log.i("MYTAG","DCompletedg $currentDate")
            return Result.success()
        }catch (e:Exception){
            return Result.failure()
        }
    }
}