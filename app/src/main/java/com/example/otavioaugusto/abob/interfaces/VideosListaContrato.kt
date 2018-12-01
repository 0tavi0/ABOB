package com.example.otavioaugusto.abob.interfaces

import com.example.otavioaugusto.abob.model.VideoYoutube
import com.example.otavioaugusto.abob.model.YoutubeDataModel

interface VideosListaContrato {

    interface View{
        fun mostrarLista(listaYoutubeModel: List<VideoYoutube>)

    }

    interface Presenter{
        fun obterLista()
    }
}