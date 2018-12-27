package com.example.otavioaugusto.abob.utils

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import com.example.otavioaugusto.abob.R

class Notification {


    companion object {


        fun mostrarNotificacao(contexto:Context, id:Int, title:String, descripiton:String, pi:PendingIntent) {

            if (Build.VERSION.SDK_INT < 16) {
                var mBuilder = NotificationCompat.Builder(contexto, id.toString())
                    .setSmallIcon(R.drawable.notification_icon_background)
                    .setContentTitle(title)
                    .setContentText(descripiton)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .build()

                val notificationManager = contexto.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(id, mBuilder)
            }else{
                var mBuilder = NotificationCompat.Builder(contexto, id.toString())
                    .setSmallIcon(R.drawable.notification_icon_background)
                    .setContentTitle(title)
                    .setContentText(descripiton)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pi)
                    .build()

                mBuilder.flags = Notification.FLAG_AUTO_CANCEL

                val notificationManager = contexto.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(id, mBuilder)

            }
        }
    }
}