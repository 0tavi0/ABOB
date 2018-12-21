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


        btnAlarme.setOnClickListener {


            setupPeriodicWorker()
        }

        btnCancelar.setOnClickListener {

            val myWorkId = periodicWorkRequest.getId()

            workManager.cancelWorkById(myWorkId)
            Log.e("cancelado", "" + myWorkId)
            txtStatus.text = "Desativado"


        }

        btnStatus.setOnClickListener {
            Log.e("status", "sdsd")



        }


    }

    fun setupPeriodicWorker() {


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
           // observeForever(observer)
            observeForever (observer)
        }
        //println("111===========${WorkManager.getInstance().getStatusesByTag(id)}====${WorkManager.getInstance().getStatusesByTag(id)?.value?.size}")
    }
    val observer=object :android.arch.lifecycle.Observer<WorkStatus> {
        override fun onChanged(t: WorkStatus?) {
            Log.e("State", ""+ t!!.state)

            if (t!!.state == State.ENQUEUED || t!!.state == State.RUNNING){
                txtStatus.text = "Ativado"
            }
        }

//        override fun onChanged(t: MutableList<WorkStatus>?) {
//            println("00=================${t?.size}")
//            (0 until (t?.size?:0)).forEach {
//                var workstaus = t!![it]
//
//                Log.e("State", ""+workstaus.state)
//
//                if (workstaus.state == State.ENQUEUED){
//                    Log.e("Medicamento não ativado","true" )
//                    txtStatus.text = "Desativado"
//                }
//
//                println("${it}==============${workstaus.id}====${workstaus.state}//${workstaus.state.isFinished}")
//            }
//        }
    }



    }









