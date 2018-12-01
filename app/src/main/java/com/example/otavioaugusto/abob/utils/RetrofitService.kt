package com.example.otavioaugusto.abob.utils

import android.util.Log
import android.widget.Toast
import com.example.otavioaugusto.abob.interfaces.ApiInterface
import com.example.otavioaugusto.abob.model.YoutubeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object {

        val BASE_URL = "https://www.googleapis.com/youtube/v3/"

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}