package com.example.otavioaugusto.abob.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.model.DataHistoricoMedicamento

class HistoricoAdapter(val listaHistorico : List<DataHistoricoMedicamento>, val context: Context):RecyclerView.Adapter<HistoricoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_historico, parent, false)
        val view = ViewHolder(v)
        return view
    }

    override fun getItemCount(): Int {
        return listaHistorico.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val t = listaHistorico[position]
        holder.txtData.text = listaHistorico[position].data
        holder.txtQuantidade.text  = t.quantidade.toString()
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

         var txtData:TextView
         var txtQuantidade:TextView


                init {
                    txtData = itemView.findViewById(R.id.txtData)
                    txtQuantidade = itemView.findViewById(R.id.txtQuantidade)

                }



    }
}