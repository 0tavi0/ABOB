package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.otavioaugusto.abob.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFeed.setOnClickListener {
            val intent = Intent(this, FeedLista::class.java)
            startActivity(intent)
        }

        btnVideos.setOnClickListener(){
            val intent = Intent(this, VideosLista::class.java)
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }

        btnAlarme.setOnClickListener {
            val intent = Intent(this, AlarmMedicamentoActivity::class.java)
            startActivity(intent)
        }

    }

    
}
