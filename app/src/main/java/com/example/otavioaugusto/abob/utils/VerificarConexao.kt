package com.example.otavioaugusto.abob.utils

import android.content.Context
import android.net.ConnectivityManager
import android.provider.Settings.Global.getString
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v7.app.AlertDialog
import com.example.otavioaugusto.abob.R

class VerificarConexao {

    companion object {

         fun isNetworkConnected(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            return networkInfo != null && networkInfo.isConnected
        }

        fun alerta(title:String, mensage:String, context: Context){
            var myAlertBuilder = AlertDialog.Builder(context)

            myAlertBuilder.setTitle(title)

            myAlertBuilder.setMessage(mensage)
            myAlertBuilder.setPositiveButton("Ok") { dialog, which ->
            }

            val dialog = myAlertBuilder.create()
            dialog.show()
        }
    }
}