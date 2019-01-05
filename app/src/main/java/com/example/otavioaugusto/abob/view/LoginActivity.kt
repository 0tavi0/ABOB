package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.interfaces.LoginContrato
import com.example.otavioaugusto.abob.presenter.LoginPresenter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContrato.View {


    lateinit var presenter : LoginContrato.Presenter
    var mAuth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        mAuth = FirebaseAuth.getInstance()

        btnCriarConta.setOnClickListener {
            val i = Intent(this, CadastrarUsuarioActivity::class.java)
            startActivity(i)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            if (presenter.verificarVazio(email,senha)) {
                presenter.login(email, senha, mAuth!!)
            }

        }

    }


    override fun showErro(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun updateUI(user: FirebaseUser) {
        if (user!=null){
            var i = Intent(this, TelaInicialActivity::class.java)
            startActivity(i)
        }

    }

    override fun onStart() {
        super.onStart()

        var currentUser = mAuth?.currentUser
        if (currentUser!=null){
            updateUI(currentUser)
        }
    }
}
