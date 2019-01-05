package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.interfaces.CadastrarUsuarioContrato
import com.example.otavioaugusto.abob.presenter.CadastrarUsuarioPresenter
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastrar_usuario.*
import com.google.firebase.auth.FirebaseUser



class CadastrarUsuarioActivity : AppCompatActivity(), CadastrarUsuarioContrato.View {


    lateinit var presenter : CadastrarUsuarioContrato.Presenter
     var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_usuario)

        mAuth = FirebaseAuth.getInstance()

        presenter = CadastrarUsuarioPresenter(this, this)




        btnCriarConta.setOnClickListener {

            var email = edtEmail.text.toString().trim()
            var senha = edtSenha.text.toString().trim()

          if ( presenter.verificarVazio(email, senha)){

              presenter.criarUsuario(email, senha, mAuth!!)

              val i = Intent(this, TelaInicialActivity::class.java)
              startActivity(i)


          }


        }





    }

    public override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.getCurrentUser()
        if (currentUser!=null){

            val i = Intent(this, HistoricoActivity::class.java)
            startActivity(i)

        }
    }


    override fun mensagemErro(msg: String) {

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

    }

    override fun showProgressBar() {
        progress.visibility = View.VISIBLE

    }

    override fun hideProgressBar() {
        progress.visibility = View.INVISIBLE
    }

}
