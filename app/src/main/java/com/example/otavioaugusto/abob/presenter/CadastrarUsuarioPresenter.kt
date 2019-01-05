package com.example.otavioaugusto.abob.presenter

import android.content.Context
import com.example.otavioaugusto.abob.interfaces.CadastrarUsuarioContrato
import android.util.Log
import com.google.firebase.auth.*


class CadastrarUsuarioPresenter(var view:CadastrarUsuarioContrato.View, context: Context) : CadastrarUsuarioContrato.Presenter {



    override fun criarUsuario(email: String, senha: String, mAuth:FirebaseAuth) {
        view.showProgressBar()

        mAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->


                if (task.isSuccessful) {
                    Log.e("sucesso","dsds")
                    //  signUpView?.onSuccess()
                } else {
                    Log.e("nao deu certo","dsds")

                    Excecao(task.exception)

                }

                view.hideProgressBar()
            }



    }


    private fun Excecao(exception: Exception?) {
        when(exception) {
            is FirebaseAuthWeakPasswordException -> view.mensagemErro("Digíte uma senha mais forte")
            is FirebaseAuthInvalidCredentialsException -> view.mensagemErro("Digíte um email válido")
            is FirebaseAuthUserCollisionException -> view.mensagemErro( "Essa conta já foi cadastrada")
            else -> {
                view.mensagemErro("Erro ao cadastrar usuário ${exception?.message}")
                exception?.printStackTrace()
            }
        }

    }


    override fun verificarVazio(email: String, senha: String):Boolean {

        var isValid = true

        if (email.isNullOrEmpty() || senha.isNullOrEmpty()) {
            isValid = false
            view.mensagemErro("Campo vazio")
        }

        return isValid



    }


}
