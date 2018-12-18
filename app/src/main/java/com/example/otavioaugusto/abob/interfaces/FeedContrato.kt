package com.example.otavioaugusto.abob.interfaces

import com.example.otavioaugusto.abob.model.Feed

interface FeedContrato {

    interface View{
        fun mostrarErroFirebase(m : String)
        fun mostrarListaFirebase(lista: ArrayList<Feed>)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface FeedPresenter{
        fun obterFeedFireabase()

    }


}