package com.example.otavioaugusto.abob.view

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.model.DataHistoricoMedicamento
import com.example.otavioaugusto.abob.utils.FirebaseDAO
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_historico.*
import java.text.SimpleDateFormat
import java.util.*

class HistoricoActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var listaHistorico: ArrayList<DataHistoricoMedicamento>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)
        mAuth = FirebaseAuth.getInstance()

        listaHistorico = ArrayList()

recuperarHistorico()

        btnPegarMedicamento.setOnClickListener {
            val currentUser = mAuth?.getCurrentUser()

            val cal = Calendar.getInstance()
            val ano = cal.get(Calendar.YEAR)
            val mes = cal.get(Calendar.MONTH)
            val dia = cal.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                val quantidade = edtQuantidade.text.toString()
                var data = "${dayOfMonth}/${month + 1}/${year}"

                val dataHistoricoMedicamento = DataHistoricoMedicamento()
                dataHistoricoMedicamento.data = data
                dataHistoricoMedicamento.quantidade = quantidade.toInt()

                listaHistorico!!.add(dataHistoricoMedicamento)


                if (currentUser != null) {

                    FirebaseDAO.salvarHistorico(currentUser.uid,listaHistorico!!)

                }

            }, ano, mes, dia)

            datePicker.show()

        }

    }


    public override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.getCurrentUser()

        if (currentUser==null){
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)

        }






    }

    fun recuperarHistorico(){
        val currentUser = mAuth?.getCurrentUser()
        Log.e("fora", "${currentUser}")

        if (currentUser!=null){
            Log.e("dentro", "${currentUser}")
            FirebaseDAO.recuperarHistorico(currentUser!!.uid)

        }

    }
}
