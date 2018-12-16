package com.example.otavioaugusto.abob.model

import com.google.gson.annotations.SerializedName

data class YoutubeDataModel(
    @SerializedName("title") val title:String = "",
    @SerializedName("thumbnails")  val thumbnails:YoutubeThumbnails,
    @SerializedName("resourceId") val video_id:YoutuebIDvideos,
    @SerializedName("description") val description:String = ""


)