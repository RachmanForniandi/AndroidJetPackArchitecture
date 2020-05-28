package com.example.learnnotification

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_settings.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        receiveInput()
    }

    private fun receiveInput(){
        val KEY_REPLY = "key_reply"
        val intent: Intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null){
            val  inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            textView.text = inputString

            val channelId="com.example.learnnotification"
            val notificationId = 45

            val repliedNotification = NotificationCompat.Builder(this,channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("Your reply received")
                .build()
            val notificationManager:NotificationManager =
                       getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(notificationId,repliedNotification)

        }
    }
}
