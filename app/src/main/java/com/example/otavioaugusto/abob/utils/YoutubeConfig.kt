package com.example.otavioaugusto.abob.utils



class YoutubeConfig {

    companion object {
        val API_KEY = "AIzaSyB72C6sg_nL7kqywglVyE2qRbTiA7dP8oc"
        val PLAYLIST_ID = "PLIpjOKdzAOzcqGTigjOFgzqKgjAMWiVah"

        fun getAPIkey(): String {
            return API_KEY
        }

        fun getIDPlaylist():String{
            return  PLAYLIST_ID
        }



    }

}