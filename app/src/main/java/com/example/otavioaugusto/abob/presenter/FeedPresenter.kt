package com.example.otavioaugusto.abob.presenter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.interfaces.ItemClickListener
import com.example.otavioaugusto.abob.model.Feed
import com.example.otavioaugusto.abob.view.FeedDetails

class FeedPresenter(var view : FeedContrato.View) : FeedContrato.FeedPresenter {
    
    override fun obterListaDoFeed() {
        val lista = arrayListOf<Feed>()
        for (i in 1..10){
            var f1 = Feed("Alimentos que ajudam no compate cotra câncer",
                "Novos estudos indicam, que novos alimentoss..")
            lista.add(f1)
        }
        view.mostrarLista(lista)

    }

    companion object {
        fun passarDadoIntent(titulo:String, subtitulo:String, contexto: Context){
            val intent = Intent(contexto, FeedDetails::class.java)
            intent.putExtra("titulo", titulo)
            intent.putExtra("subtitulo",subtitulo)
            contexto.startActivity(intent)
        }

    }



}