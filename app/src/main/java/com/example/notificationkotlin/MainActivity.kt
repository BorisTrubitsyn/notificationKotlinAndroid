package com.example.notificationkotlin

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {
    private val NOTIFY_ID = 101

    // Идентификатор канала
    private val CHANNEL_ID = "Cat channel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn)


        btn.setOnClickListener {
            //open main activity
            val notificationIntent = Intent(this@MainActivity, MainActivity::class.java)
            val contentIntent = PendingIntent.getActivity(this@MainActivity,
                    0, notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT)
            //send notification
            val builder = NotificationCompat.Builder(this@MainActivity, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Напоминание")
                    .setContentText("Пора покормить кота")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(contentIntent)
            val notificationManager = NotificationManagerCompat.from(this@MainActivity)
            notificationManager.notify(NOTIFY_ID, builder.build())
        }
    }
}
