package com.example.otavioaugusto.abob.interfaces

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

interface CadastrarUsuarioContrato {

    interface View{
        fun mensagemErro(msg:String)
        fun showProgressBar()
        fun hideProgressBar()



    }

    interface Presenter{
        fun verificarVazio(email:String, senha:String, nome:String):Boolean
        fun criarUsuario(email: String, senha: String, mAuth:FirebaseAuth, nome: String)


    }
}