package com.example.otavioaugusto.abob.model

import com.google.gson.annotations.SerializedName

class YoutubeThumbnails(
    @SerializedName("high") val thumbnailsHigh : YoutubeThumbnailsHigh
) {
    class YoutubeThumbnailsHigh {
        @SerializedName("url") val urlImagem : String = ""

    }
}