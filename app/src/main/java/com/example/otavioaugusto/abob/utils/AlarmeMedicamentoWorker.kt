package com.example.otavioaugusto.abob.utils

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.otavioaugusto.abob.view.AlarmMedicamentoActivity
import com.example.otavioaugusto.abob.view.AlarmMedicamentoDetails
import com.example.otavioaugusto.abob.view.EmailActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class AlarmeMedicamentoWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {


        return try {
            val cal = Calendar.getInstance()
            Log.e("Data", ""+(SimpleDateFormat("H : m").format(cal.time)))
            Log.e("Data", ""+(SimpleDateFormat("M/d - H : mm").format(cal.time)))

            Log.e("Medicametno","Hora te tomar" + cal.time)

            Result.success()
        } catch (throwable: Throwable) {
            Log.e("Erro", "", throwable)
            Result.failure()
        }
    }
}







//
//val intent = Intent(applicationContext, AlarmMedicamentoActivity::class.java).apply {
//    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//}
//val pendingIntent: PendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, 0)
//
//
//Notification.mostrarNotificacao(applicationContext, 1, "Aveloz", "Hora te tomar o medicamenyo", pendingIntent)
//
//val cal = Calendar.getInstance()
//Log.e("Data", ""+(SimpleDateFormat("H : m").format(cal.time)))
//Log.e("Data", ""+(SimpleDateFormat("M/d - H : m").format(cal.time)))
//
//
//var intent1  = Intent(applicationContext, AlarmMedicamentoDetails::class.java)
////        intent1.putExtra("hora", cal.time)
//applicationContext.startActivity(intent1)
//
//Log.e("Medicametno","Hora te tomar" + cal.time)