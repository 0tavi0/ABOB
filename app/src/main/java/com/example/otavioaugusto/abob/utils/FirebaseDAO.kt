package com.example.otavioaugusto.abob.utils

import com.example.otavioaugusto.abob.model.Usuario
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FirebaseDAO {

    companion object {
        fun salvarUsuarioFirebase(email: String, id:String, nome:String) {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("usuarios/" )
            var usuario = Usuario(email,nome)
            myRef.child(id).setValue(usuario)
        }

       fun salvarHistorico(id: String, datas:ArrayList<String>){

           val database = FirebaseDatabase.getInstance()
           val myRef = database.getReference("usuarios/" )

           myRef.child(id).child("historicoPegarMedicamento").setValue(datas)

       }
    }
}