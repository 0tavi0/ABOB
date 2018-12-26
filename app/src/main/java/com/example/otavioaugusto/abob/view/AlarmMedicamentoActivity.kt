package com.example.otavioaugusto.abob.view

import android.arch.lifecycle.LiveData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Nullable
import android.util.Log
import androidx.work.PeriodicWorkRequest
import androidx.work.State
import androidx.work.WorkManager
import androidx.work.WorkStatus
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.utils.AlarmeMedicamentoWorker
import kotlinx.android.synthetic.main.activity_alarm_medicamento.*
import java.util.*
import java.util.concurrent.TimeUnit

class AlarmMedicamentoActivity : AppCompatActivity() {

    private lateinit var workManager: WorkManager
    private lateinit var periodicWorkRequest: PeriodicWorkRequest



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_medicamento)

        workManager = WorkManager.getInstance()!!


        switch1.setOnClickListener {
            if (switch1.isChecked){
                AlarmMedicamento()
                txtStatus.text = "Ativado"
            }else{
                cancelarAlarm()
                txtStatus.text = "Desativado"
            }

        }




    }

    fun AlarmMedicamento() {


        val calendar = Calendar.getInstance()
//
//        val works = workManager.getStatusesByTag(id)
//
//        if (works.value != null && works.value?.isNotEmpty()!!) {
//
//            return
//        }


        val work = PeriodicWorkRequest.Builder(
            AlarmeMedicamentoWorker::class.java,
            15, TimeUnit.MINUTES
        )


        periodicWorkRequest = work.build()

        workManager.enqueue(periodicWorkRequest)

        val myWorkId = periodicWorkRequest.getId()

        getStatus(myWorkId)







        Log.e("agendado", "" + calendar.time)
        Log.e("agendado", "ID : __" + myWorkId)



    }


    fun getStatus(id:UUID) {
        WorkManager.getInstance().getStatusById(id)?.apply {
            observeForever (observer)
        }
    }
    val observer=object :android.arch.lifecycle.Observer<WorkStatus> {
        override fun onChanged(t: WorkStatus?) {
            Log.e("State", ""+ t!!.state)

            if (t!!.state == State.ENQUEUED || t!!.state == State.RUNNING){
                Log.e("State", "ativado")

            }
        }

    }

    fun cancelarAlarm(){
        val myWorkId = periodicWorkRequest.getId()

        workManager.cancelWorkById(myWorkId)

    }


    }









