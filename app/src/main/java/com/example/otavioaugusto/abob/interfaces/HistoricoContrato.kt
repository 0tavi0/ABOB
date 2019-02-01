package com.example.otavioaugusto.abob.interfaces

import com.example.otavioaugusto.abob.model.DataHistoricoMedicamento
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface HistoricoContrato {

    interface View{
        fun setLista(lista:List<DataHistoricoMedicamento>)

    }

    interface Presenter{
        fun getListaHistorico(id: String)
    }

}