package com.example.otavioaugusto.abob.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.presenter.FeedPresenter
import kotlinx.android.synthetic.main.activity_feed_details.*
import kotlinx.android.synthetic.main.content_feed_details.*

class FeedDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_details)
        setSupportActionBar(toolbar)




        var intent = intent
        val titulo = intent.getStringExtra("titulo")
        val subtitulo = intent.getStringExtra("subtitulo")
        val descricao = intent.getStringExtra("descricao")
        val urlImg = intent.getStringExtra("img")

        txtDetailsSubtitulo.setText(descricao)

        FeedPresenter.picassoImagem(urlImg, imgCollapsing)

        setTitle(titulo)



    }
}
