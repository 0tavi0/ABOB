package com.example.otavioaugusto.abob.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.model.VideoYoutube
import com.example.otavioaugusto.abob.presenter.VideosPresenter

class VideosAdapter(val listaVideos: List<VideoYoutube>, val context: Context): RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_videos, parent, false)
        val view = ViewHolder(v)
        return  view
    }

    override fun getItemCount(): Int {
        return listaVideos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tzt.text = listaVideos[position].IdVideo
        VideosPresenter.picassoImagem(listaVideos[position].urlImagem, holder.imgUrl)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var tzt = itemView.findViewById(R.id.txtItemVideo) as TextView
        var imgUrl = itemView.findViewById(R.id.imgItemVideo) as ImageView

    }
}