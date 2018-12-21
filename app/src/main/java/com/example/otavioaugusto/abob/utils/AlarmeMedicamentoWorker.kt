package com.example.otavioaugusto.abob.utils

import android.util.Log
import androidx.work.Worker
import java.util.*

class AlarmeMedicamentoWorker : Worker() {
    override fun doWork(): WorkerResult {

        val cal = Calendar.getInstance()


        Log.e("Medicametno","Hora te tomar" + cal.time)
        return WorkerResult.SUCCESS
    }
}