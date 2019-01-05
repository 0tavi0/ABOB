package com.example.otavioaugusto.abob.interfaces

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface LoginContrato {
    interface View{

        fun showErro(msg:String)
        fun updateUI(user:FirebaseUser)

    }

    interface Presenter{
        fun login(email:String, senha:String, mAuth:FirebaseAuth)
        fun verificarVazio(email:String, senha:String):Boolean

    }
}