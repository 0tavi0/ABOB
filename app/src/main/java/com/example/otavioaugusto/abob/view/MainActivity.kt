package com.example.otavioaugusto.abob.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.adapters.FeedAdapter
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.model.Feed
import com.example.otavioaugusto.abob.presenter.FeedPresenter
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FeedContrato.View {



    lateinit var feedPresenter: FeedContrato.FeedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        feedPresenter = FeedPresenter(this)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        feedPresenter.obterListaDoFeed()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)




    }


    override fun mostrarLista(lista: ArrayList<Feed>) {
        val adapter = FeedAdapter(lista, this)
        recycler.adapter = adapter

    }





    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_feed -> {
                view_flipper.displayedChild = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_videos -> {
                view_flipper.displayedChild = 1

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
