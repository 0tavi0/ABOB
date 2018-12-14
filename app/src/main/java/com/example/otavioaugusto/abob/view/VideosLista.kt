package com.example.otavioaugusto.abob.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.adapters.VideosAdapter
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.interfaces.VideosListaContrato
import com.example.otavioaugusto.abob.model.VideoYoutube
import com.example.otavioaugusto.abob.model.YoutubeDataModel
import com.example.otavioaugusto.abob.presenter.VideosPresenter
import kotlinx.android.synthetic.main.activity_videos_lista.*

class VideosLista : AppCompatActivity(), VideosListaContrato.View {


      lateinit var videoPresenter: VideosListaContrato.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos_lista)

        videoPresenter = VideosPresenter(this)

       videoPresenter.obterLista()
        initRecyler()

    }

    override fun mostrarLista(listaYoutubeModel: List<VideoYoutube>) {

        val adapter = VideosAdapter(listaYoutubeModel, this)
        recyclerVideos.adapter = adapter

        for (i in listaYoutubeModel){
            Log.e("Imagem", "${i.urlImagem}")

        }

    }

    fun initRecyler(){

        recyclerVideos.layoutManager = LinearLayoutManager(this)
        recyclerVideos.setHasFixedSize(true)
    }
}

