package com.example.otavioaugusto.abob.presenter

import android.util.Log
import android.widget.Toast
import com.example.otavioaugusto.abob.interfaces.ApiInterface
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.interfaces.VideosListaContrato
import com.example.otavioaugusto.abob.model.VideoYoutube
import com.example.otavioaugusto.abob.model.YoutubeDataModel
import com.example.otavioaugusto.abob.model.YoutubeResponse
import com.example.otavioaugusto.abob.utils.RetrofitService
import com.example.otavioaugusto.abob.utils.YoutubeConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VideosPresenter(var view : VideosListaContrato.View):VideosListaContrato.Presenter {


    val GOOGLE_YOUTUBE_API_KEY = YoutubeConfig.getAPIkey()
    val PLAYLIST_ID = YoutubeConfig.getIDPlaylist()
    var listaDadosYoutube: MutableList<VideoYoutube> = ArrayList()

    override fun obterLista() {
        var call = RetrofitService
            .retrofit.create(ApiInterface::class.java)
            .getYoutubeData(PLAYLIST_ID,GOOGLE_YOUTUBE_API_KEY)

        call.enqueue(object : Callback<YoutubeResponse> {
            override fun onFailure(call: Call<YoutubeResponse>, t: Throwable) {
                Log.e("errro ", "${t.message}")
            }

            override fun onResponse(call: Call<YoutubeResponse>, response: Response<YoutubeResponse>) {

                if (response.isSuccessful) {
                    var listaYoutube = response.body()!!.lista

                    for (i in listaYoutube){

                        var urlImagem = i.youtubeModel.thumbnails.thumbnailsHigh.urlImagem
                        var idVide = i.youtubeModel.video_id.urlIDvideos

                        var videoYoutube = VideoYoutube(urlImagem, idVide)

                        listaDadosYoutube.add(videoYoutube)

                        view.mostrarLista(listaDadosYoutube)

                    }

                }else{
                    Log.e("fora", ""+response.code())

                }
            }
        })
    }
}