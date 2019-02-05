package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
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
import java.io.IOException


class CadastrarUsuarioActivity : AppCompatActivity(), CadastrarUsuarioContrato.View {



    lateinit var presenter : CadastrarUsuarioContrato.Presenter
    var mAuth: FirebaseAuth? = null
    val GALERIA = 1
    lateinit var mFotoSelecionada:Uri



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_usuario)

        mAuth = FirebaseAuth.getInstance()

        presenter = CadastrarUsuarioPresenter(this, this)

        btnFotoPerfil.setOnClickListener {
            selecionarFoto()
        }



        btnCriarConta.setOnClickListener {

            var email = edtEmail.text.toString().trim()
            var senha = edtSenha.text.toString().trim()
            var nome = edtNome.text.toString()

            if ( presenter.verificarVazio(email, senha, nome)){

                presenter.criarUsuario(email, senha, mAuth!!,nome)

                val i = Intent(this, TelaInicialActivity::class.java)
                startActivity(i)


            }


        }





    }

    fun selecionarFoto() {
        val galleryIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryIntent.setType("image/*")

        startActivityForResult(galleryIntent, GALERIA)
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.getCurrentUser()
        if (currentUser!=null){

            val i = Intent(this, HistoricoActivity::class.java)
            startActivity(i)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALERIA){

            mFotoSelecionada = data!!.data

            try
            {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, mFotoSelecionada)
               // val path = saveImage(bitmap)
               // imgPerfil.setImageBitmap(bitmap)
                imgPerfil.setImageDrawable( BitmapDrawable(bitmap))
                btnFotoPerfil.getBackground().setAlpha(0)



            }
            catch (e: IOException) {
                e.printStackTrace()
            }

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
