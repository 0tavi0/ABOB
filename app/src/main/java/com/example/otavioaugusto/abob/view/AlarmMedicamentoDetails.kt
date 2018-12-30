package com.example.otavioaugusto.abob.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.otavioaugusto.abob.R
import kotlinx.android.synthetic.main.activity_alarm_medicamento_details.*

class AlarmMedicamentoDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_medicamento_details)


        var intent = intent
        var hora = intent.getStringExtra("hora")
        var data = intent.getStringExtra("data")

        txtData.text = data
        txtHora.text = hora



        Glide.with(this)
            .asGif()
            .load(R.drawable.gif)
            .into(imgGIF)

        fab.setOnClickListener { view ->
            finish()
        }
    }
}
