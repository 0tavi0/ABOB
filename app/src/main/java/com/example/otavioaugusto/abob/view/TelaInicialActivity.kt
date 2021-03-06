package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.utils.VerificarConexao
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_main2.*
import kotlinx.android.synthetic.main.nav_header_main2.view.*

class TelaInicialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)


        mAuth = FirebaseAuth.getInstance()

        btnFeed.setOnClickListener {
            val intent = Intent(this, FeedLista::class.java)
            startActivity(intent)
        }

        btnVideos.setOnClickListener(){
            val intent = Intent(this, VideosLista::class.java)
            startActivity(intent)
        }

        btnEmail.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }

        btnAlarme.setOnClickListener {
            val intent = Intent(this, AlarmMedicamentoActivity::class.java)
            startActivity(intent)
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val currentUser = mAuth?.getCurrentUser()

        if (currentUser!=null) {

            nav_view.getHeaderView(0).txtEmailNavView.text = mAuth!!.currentUser!!.email
        }

    }

    override fun onStart() {
        super.onStart()

        val currentUser = mAuth?.getCurrentUser()

        if (currentUser!=null) {

            nav_view.getHeaderView(0).txtEmailNavView.text = mAuth!!.currentUser!!.email
        }

    }



    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_historico -> {

                var intent  = Intent(this, HistoricoActivity::class.java)
                startActivity(intent)

            }
            R.id.nav_share -> {

            }
            R.id.nav_sair -> {

                mAuth?.signOut()

                nav_view.getHeaderView(0).txtEmailNavView.text = getString(R.string.nav_header_subtitle)


            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
