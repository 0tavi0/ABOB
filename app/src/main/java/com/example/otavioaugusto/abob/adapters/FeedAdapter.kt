package com.example.otavioaugusto.abob.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.model.Feed

class FeedAdapter(val listaFeed: ArrayList<Feed>, val context: Context) : RecyclerView.Adapter<FeedAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        val view = ViewHolder(v)
        return  view
    }

    override fun getItemCount(): Int {
       return listaFeed.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtTitulo.text = listaFeed[position].titulo
        holder.txtSubtitulo.text = listaFeed[position].subtitulo


    }



class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtTitulo = itemView.findViewById(R.id.txtTitulo) as TextView
    val txtSubtitulo = itemView.findViewById(R.id.txtSubtitulo) as TextView


}
}
