package com.example.otavioaugusto.abob.interfaces

import com.example.otavioaugusto.abob.model.YoutubeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("playlistItems?part=snippet&&maxResults=20&")
    fun getYoutubeData(@Query("playlistId") playlistId:String,
                       @Query("key") key:String
                       ) : Call<YoutubeResponse>


}