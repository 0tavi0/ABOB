package com.example.otavioaugusto.abob.model

import android.net.Uri
import android.widget.ImageView

class Feed (
    val titulo: String,
    val subtitulo: String,
    val descricao: String
){

    constructor():this( "","", ""){}

    var id:String = ""
    var urlImagem: String = ""
}
