package com.example.otavioaugusto.abob.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.otavioaugusto.abob.R
import com.example.otavioaugusto.abob.utils.YoutubeConfig
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video_details.*


class VideoDetails :  YouTubeBaseActivity() {

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    lateinit var id:String
    lateinit var description:String
    lateinit var title:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_details)



        showVideo()
        dadosIntent()



        btnShare.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND_MULTIPLE
               // putExtra(Intent.EXTRA_TEXT, titleShared)
                putExtra(Intent.EXTRA_TEXT, "https://www.youtube.com/watch?v=" + id)
                type = "text/plain"
            }
            startActivity(sendIntent)
        }

    }



    fun showVideo(){
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

    fun dadosIntent(){
        var intent = intent
        id = intent.getStringExtra("id")
        description = intent.getStringExtra("description")
        title = intent.getStringExtra("title")

        txt_itemDescrVideoDetails.text = description
        txt_itemTitle_videoDetails.text = title

    }






}



