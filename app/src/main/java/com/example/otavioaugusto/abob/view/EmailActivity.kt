package com.example.otavioaugusto.abob.view

import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.interfaces.EmailContrato
import com.example.otavioaugusto.abob.presenter.EmailPresenter
import com.example.otavioaugusto.abob.utils.Notification
import com.example.otavioaugusto.abob.utils.VerificarConexao
import kotlinx.android.synthetic.main.activity_email.*

class EmailActivity : AppCompatActivity(), EmailContrato.View {

    lateinit var presenter: EmailContrato.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)


        if (VerificarConexao.isNetworkConnected(this)){
            Log.e("Conectado","true")
        }else{
            VerificarConexao.alerta("Opss..", "Você não está conectado! Favor conectar a internet",this)
            Log.e("Não Conectado","false")

        }

        presenter = EmailPresenter(this,this)



        btnEnviarEmail.setOnClickListener {
            var assunto = edtAssunto.text.toString().trim()
            var mensagem = edtMensagem.text.toString().trim()

            presenter.enviarEmail(assunto,mensagem)




        }

    }



    override fun mensagemErro(msg: String) {

        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()

    }



    fun Email(assunto:String, mensagem:String){

    }
}
