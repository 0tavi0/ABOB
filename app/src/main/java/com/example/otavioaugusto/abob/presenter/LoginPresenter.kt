package com.example.otavioaugusto.abob.presenter

import android.util.Log
import com.example.otavioaugusto.abob.interfaces.LoginContrato
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.*


class LoginPresenter(val view:LoginContrato.View) : LoginContrato.Presenter {

    override fun login(email: String, senha: String, mAuth: FirebaseAuth) {

        mAuth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuth.currentUser
                    view.updateUI(user!!)
                } else {

                    Excecao(task.exception)
                    Log.e("erro",""+task.exception.toString())
                  // view.updateUI(null!!)
                }

            }
    }

    private fun Excecao(exception: Exception?) {
        when(exception) {
            is FirebaseAuthInvalidCredentialsException -> view.showErro("A senha é inválida ou o usuário não possui uma senha")
            is FirebaseNetworkException -> view.showErro( "Por favor, Verifique sua conexão.")
            is FirebaseAuthInvalidUserException -> view.showErro("Email incorreto! tente novamente!")
            else -> {
                view.showErro("Oops. Ação indisponível no   momento. Por favor tente mais tarde.")
                exception?.printStackTrace()
            }
        }

    }

    override fun verificarVazio(email: String, senha: String): Boolean {
        var isValid = true

        if (email.isNullOrEmpty() || senha.isNullOrEmpty()) {
            isValid = false
            view.showErro("Campo vazio")
        }

        return isValid

    }


}