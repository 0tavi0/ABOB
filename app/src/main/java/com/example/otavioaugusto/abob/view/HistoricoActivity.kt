package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.utils.FirebaseDAO
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_historico.*
import java.text.SimpleDateFormat
import java.util.*

class HistoricoActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var listaDatas: ArrayList<String>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)
        mAuth = FirebaseAuth.getInstance()

        listaDatas = ArrayList()

        btnPegarMedicamento.setOnClickListener {
            val currentUser = mAuth?.getCurrentUser()


            val cal = Calendar.getInstance()
            var data = (SimpleDateFormat("H:mm:ss").format(cal.time))

            listaDatas!!.add(data)

            if (currentUser != null) {
                FirebaseDAO.salvarHistorico(currentUser.uid, listaDatas!!)

            }
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
}
