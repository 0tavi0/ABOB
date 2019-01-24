package com.example.otavioaugusto.abob.utils

import android.util.Log
import com.example.otavioaugusto.abob.model.DataHistoricoMedicamento
import com.example.otavioaugusto.abob.model.Medicamento
import com.example.otavioaugusto.abob.model.Usuario
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

       fun salvarHistorico(id: String, datas:ArrayList<DataHistoricoMedicamento>){
           val database = FirebaseDatabase.getInstance()
           val myRef = database.getReference("usuarios/" )
           val medicamento =  Medicamento(datas)

           myRef.child(id).child("HistoricoPegarMedicamento").setValue(medicamento)

       }

        fun recuperarHistorico(id:String){

            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("usuarios/${id}/HistoricoPegarMedicamento/datas" )

            val messageListener = object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        val datas = dataSnapshot.children
                        for (i in datas){

                            var lista = arrayListOf<DataHistoricoMedicamento>()

                            val data = i.child("data").getValue(String::class.java)
                            val quantidade = i.child("quantidade").getValue(Int::class.java)

                            val dataHistoricoMedicamento = DataHistoricoMedicamento()
                            dataHistoricoMedicamento.data = data.toString()
                            dataHistoricoMedicamento.quantidade = quantidade!!.toInt()
                            lista.add(dataHistoricoMedicamento)



                               Log.e("Lista ", "${lista}")



                        }







//                        Log.e("Quantidade", "${data}")


                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                }
            }

            myRef!!.addValueEventListener(messageListener)
        }
    }
}