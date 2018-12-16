package com.example.otavioaugusto.abob.presenter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.interfaces.ApiInterface
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.interfaces.ItemClickListener
import com.example.otavioaugusto.abob.model.Feed
import com.example.otavioaugusto.abob.model.YoutubeDataModel
import com.example.otavioaugusto.abob.utils.YoutubeConfig
import com.example.otavioaugusto.abob.view.FeedDetails
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeedPresenter(var view : FeedContrato.View) : FeedContrato.FeedPresenter {

   lateinit var listaFeed: ArrayList<Feed>

    override fun obterFeedFireabase() {

        listaFeed = ArrayList()
        val ref = FirebaseDatabase.getInstance().getReference("feed")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                view.mostrarErroFirebase(p0.message)
            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0!!.exists()){
                   // listaFeed.clear()
                    for (feed in p0.children){
                        var feed = feed.getValue(Feed::class.java)
                        listaFeed.add(feed!!)
                        view.mostrarListaFirebase(listaFeed)
                    }
                }

            }

        })
    }
    companion object {
        fun passarDadoIntent(titulo:String, subtitulo:String, descricao:String, img:String, contexto: Context){
            val intent = Intent(contexto, FeedDetails::class.java)
            intent.putExtra("titulo", titulo)
            intent.putExtra("subtitulo",subtitulo)
            intent.putExtra("descricao", descricao)
            intent.putExtra("img", img)
            contexto.startActivity(intent)
        }

        fun picassoImagem(url:String, imgView:ImageView){
            Picasso
                .get()
                .load(Uri.parse(url))
                .into(imgView)

        }

    }
}