package com.example.otavioaugusto.abob.presenter

import android.util.Log
import com.example.otavioaugusto.abob.interfaces.HistoricoContrato
import com.example.otavioaugusto.abob.model.DataHistoricoMedicamento
import com.example.otavioaugusto.abob.utils.FirebaseDAO
import com.example.otavioaugusto.abob.view.HistoricoActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HistoricoPresenter(var view:HistoricoContrato.View):HistoricoContrato.Presenter {

    override fun getListaHistorico(id:String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("usuarios/${id}/datas" )
        var lista = arrayListOf<DataHistoricoMedicamento>()

        val messageListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val datas = dataSnapshot.children
                    for (i in datas){
                        val data = i.child("data").getValue(String::class.java)
                        val quantidade = i.child("quantidade").getValue(Int::class.java)

                        val dataHistoricoMedicamento = DataHistoricoMedicamento()
                        dataHistoricoMedicamento.data = data.toString()
                        dataHistoricoMedicamento.quantidade = quantidade!!.toInt()
                        lista.add(dataHistoricoMedicamento)

                        view.setLista(lista)

                    }

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        myRef!!.addValueEventListener(messageListener)


    }

    }
