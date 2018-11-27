package com.example.otavioaugusto.abob.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.adapters.FeedAdapter
import com.example.otavioaugusto.abob.interfaces.FeedContrato
import com.example.otavioaugusto.abob.model.Feed
import com.example.otavioaugusto.abob.presenter.FeedPresenter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

        feedPresenter.obterFeedFireabase()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        
    }


    override fun mostrarListaFirebase(lista: ArrayList<Feed>) {
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


    override fun mostrarErroFirebase(m: String) {
        Toast.makeText(this, m, Toast.LENGTH_LONG)
    }

    fun saveFirebase (){
        val ref = FirebaseDatabase.getInstance().getReference("feed")
        val idFeed = ref.push().key

        val feed = Feed("Titulo da postagem", "Subtitulo da postagem")
        feed.id = idFeed.toString()

        ref.child(idFeed!!).setValue(feed).addOnCompleteListener {
            Log.e("Salvo", "Completo")
        }
    }



}
