package com.example.otavioaugusto.abob.presenter

import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.model.Feed

class FeedPresenter(var view : FeedContrato.View) : FeedContrato.FeedPresenter {




    override fun obterListaDoFeed() {
        val lista = arrayListOf<Feed>()

        for (i in 1..10){
            var f1 = Feed("Alimentos que ajudam no compate cotra câncer", "Novos estudos indicam, que novos alimentoss..")
            lista.add(f1)
        }



        view.mostrarLista(lista)


    }

    private fun feeds(): List<Feed> {
        return listOf(
            Feed("Leitura",
                "Livro de Kotlin com Android"),
            Feed("Pesquisa",
                "Como posso melhorar o código dos meus projetos"),
            Feed("Estudo",
                "Como sincronizar minha App com um Web Service"))
    }
}