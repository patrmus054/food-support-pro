package com.example.napomocinzynierom.data.remote

import com.google.gson.annotations.SerializedName

class LoginResponde
{
    @SerializedName("message")
    var message: String? = null

    @SerializedName("error")
    var error: String? = null

    @SerializedName("data")
    var data: Data? = null
}

class Data
{
    @SerializedName("id")
    var id: String? = null
}

class LoginBody
{
    @SerializedName("login")
    var login: String? = null
    @SerializedName("password")
    var password: String? = null
}
