package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.otavioaugusto.abob.R
import com.google.firebase.auth.FirebaseAuth

class HistoricoActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)
        mAuth = FirebaseAuth.getInstance()
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
