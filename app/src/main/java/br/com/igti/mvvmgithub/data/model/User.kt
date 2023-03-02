package br.com.igti.mvvmgithub.data.model

//annotation class SerializeName

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("login")
    val login:String = "",
    @SerializedName("html_url")
    val url: String = "",
    @SerializedName("avatar_url")
    val avatar: String = ""
)
