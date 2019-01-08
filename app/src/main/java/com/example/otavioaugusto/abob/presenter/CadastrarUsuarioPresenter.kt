package com.example.otavioaugusto.abob.presenter

import android.content.Context
import com.example.otavioaugusto.abob.interfaces.CadastrarUsuarioContrato
import android.util.Log
import com.example.otavioaugusto.abob.utils.FirebaseDAO
import com.google.firebase.auth.*
import com.google.firebase.database.FirebaseDatabase


class CadastrarUsuarioPresenter(var view:CadastrarUsuarioContrato.View, context: Context) : CadastrarUsuarioContrato.Presenter {





    override fun criarUsuario(email: String, senha: String, mAuth:FirebaseAuth, nome: String){
        view.showProgressBar()

        mAuth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { task ->


                if (task.isSuccessful) {

                   var user =  mAuth.currentUser

                        //view.recuperarUsuarioID(user!!)

                    FirebaseDAO.salvarUsuarioFirebase(user!!.email!!,user.uid, nome)



                    Log.e("sucesso---"+user!!.uid,"dsds"+user.email)
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


    override fun verificarVazio(email: String, senha: String, nome:String):Boolean {

        var isValid = true

        if (email.isNullOrEmpty() || senha.isNullOrEmpty() || nome.isNullOrEmpty()) {
            isValid = false
            view.mensagemErro("Campo vazio")
        }

        return isValid



    }




}
