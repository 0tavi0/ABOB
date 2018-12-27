package com.example.otavioaugusto.abob.utils

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Worker
import com.example.otavioaugusto.abob.view.AlarmMedicamentoActivity
import com.example.otavioaugusto.abob.view.EmailActivity
import java.util.*

class AlarmeMedicamentoWorker : Worker() {
    override fun doWork(): WorkerResult {
        val intent = Intent(applicationContext, AlarmMedicamentoActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, 0)


        Notification.mostrarNotificacao(applicationContext, 1, "Aveloz", "Hora te tomar o medicamenyo", pendingIntent)


        var intent1  = Intent(applicationContext, EmailActivity::class.java)
        applicationContext.startActivity(intent1)

        val cal = Calendar.getInstance()
        Log.e("Medicametno","Hora te tomar" + cal.time)
        return WorkerResult.SUCCESS
    }





}