package com.example.otavioaugusto.abob.interfaces

import com.example.otavioaugusto.abob.model.Feed

interface FeedContrato {
    interface View{
        fun mostrarLista(lista : ArrayList<Feed>)


    }

    interface FeedPresenter{
        fun obterListaDoFeed()
    }
}