package com.example.otavioaugusto.abob.interfaces

import android.view.View
import android.widget.TextView

interface ItemClickListener {

    fun onCustomClick(view:View, position:Int, titulo:TextView, subtitulo:TextView)

    interface clickVideo{

        fun onClickVideos(view:View, position: Int)


    }

}