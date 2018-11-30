package com.example.otavioaugusto.abob.model

import com.google.gson.annotations.SerializedName

data class YoutubeResponse (
    @SerializedName("items")  val lista : List<YoutubeItens>

)