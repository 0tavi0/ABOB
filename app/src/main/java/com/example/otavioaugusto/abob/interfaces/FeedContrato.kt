package com.example.otavioaugusto.abob.interfaces

import com.example.otavioaugusto.abob.model.Feed

interface FeedContrato {

    interface View{
        fun mostrarErroFirebase(m : String)
        fun mostrarListaFirebase(lista: ArrayList<Feed>)
    }

    interface FeedPresenter{
        fun obterFeedFireabase()

    }


}