package com.example.otavioaugusto.abob.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.utils.YoutubeConfig
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video_details.*
import com.example.otavioaugusto.abob.interfaces.ApiInterface
import com.example.otavioaugusto.abob.model.YoutubeResponse
import com.example.otavioaugusto.abob.utils.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class VideoDetails :  YouTubeBaseActivity() {

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_details)


        initUI()

        var intent = intent
        id = intent.getStringExtra("id")

    }

    fun initUI(){
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                p1!!.loadVideo(id)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Log.e("erro", "${p1!!.name}")
            }

        }

        playerYoutube.initialize(YoutubeConfig.getAPIkey(), youtubePlayerInit)
    }


}



