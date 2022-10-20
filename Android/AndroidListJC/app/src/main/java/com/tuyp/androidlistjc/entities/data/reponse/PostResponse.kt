package com.tuyp.androidlistjc.entities.data.reponse

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId")
    val userID: Int,
    val id: Int,
    val title: String,
    val body: String
)
