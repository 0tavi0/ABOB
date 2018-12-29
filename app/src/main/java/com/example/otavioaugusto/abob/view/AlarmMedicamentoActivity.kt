package com.example.otavioaugusto.abob.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.utils.AlarmeMedicamentoWorker
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_alarm_medicamento.*
import java.util.*
import java.util.concurrent.TimeUnit

class AlarmMedicamentoActivity : AppCompatActivity() {

    private lateinit var workManager: WorkManager
    var periodicWorkRequest: PeriodicWorkRequest? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_medicamento)
        Hawk.init(this).build()


        workManager = WorkManager.getInstance()

        var status = Hawk.get<Boolean>("status")

        Log.e("StatusOncreate", ""+status)

        if (status != null){
            txtStatus.text = "Ativado"
            switch1.setChecked(true)

        }else{
            txtStatus.text = "Desativado"

        }

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

        val work = PeriodicWorkRequest.Builder(
            AlarmeMedicamentoWorker::class.java,
            8, TimeUnit.HOURS
        )

        periodicWorkRequest = work.build()

        workManager.enqueue(periodicWorkRequest!!)

        val myWorkId = periodicWorkRequest!!.getId()

        getStatus(myWorkId)


        Log.e("agendado", "" + calendar.time)
        Log.e("agendado", "ID :" + myWorkId)


    }

    fun cancelarAlarm(){
        val myWorkId = periodicWorkRequest?.getId()
        workManager.cancelAllWork()
        Hawk.delete("status")
        Log.e("cancelado", "ID : __" + myWorkId)


    }

    fun getStatus(id: UUID): LiveData<WorkInfo> {
        val observer = Observer<WorkInfo> { t ->
            if (t!!.state == WorkInfo.State.ENQUEUED || t!!.state == WorkInfo.State.RUNNING) {
                Log.e("Stated", "ativado")

                Hawk.put("status", true)

            }

        }

        workManager.getWorkInfoByIdLiveData(id).observeForever(observer)

        return workManager.getWorkInfoByIdLiveData(id)
    }


}













