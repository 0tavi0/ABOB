package com.example.otavioaugusto.abob.presenter

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.otavioaugusto.abob.interfaces.EmailContrato
import java.lang.Exception

class EmailPresenter(var view:EmailContrato.View, var context: Context):EmailContrato.Presenter {

    override fun enviarEmail(assunto: String, mensagem: String) {
        var intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abobremessa@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto)
        intent.putExtra(Intent.EXTRA_TEXT, mensagem)


        try {
            context.startActivity(Intent.createChooser(intent, "Escolha seu Aplicativo de email favorito!"))

        }catch (e:Exception){
            view.mensagemErro(e.toString())
        }

    }




}
