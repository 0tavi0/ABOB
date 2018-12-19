package com.example.otavioaugusto.abob.interfaces

interface EmailContrato {

    interface View{
        fun mensagemErro(msg:String)
    }

    interface Presenter{
        fun enviarEmail(assunto:String, mensagem:String)
    }



}