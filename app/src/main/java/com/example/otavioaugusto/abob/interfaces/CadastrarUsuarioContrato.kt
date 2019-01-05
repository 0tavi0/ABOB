package com.example.otavioaugusto.abob.interfaces

import android.content.Context
import com.google.firebase.auth.FirebaseAuth

interface CadastrarUsuarioContrato {

    interface View{
        fun mensagemErro(msg:String)
        fun showProgressBar()
        fun hideProgressBar()


    }

    interface Presenter{
        fun verificarVazio(email:String, senha:String):Boolean
        fun criarUsuario(email: String, senha: String, mAuth:FirebaseAuth)

    }
}