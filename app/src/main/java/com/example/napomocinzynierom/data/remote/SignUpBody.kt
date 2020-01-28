package com.example.napomocinzynierom.data.remote

import com.google.gson.annotations.SerializedName

class SignUpBody {
    @SerializedName("login")
    var newUserlogin: String? = null
    @SerializedName("password")
    var newUserpassword: String? = null
    @SerializedName("firstName")
    var newUserfirstName: String? = null
    @SerializedName("lastName")
    var newUserLastName: String? = null
}

class SignUpResponde{
    @SerializedName("message")
    var newUserSignUpResponde: String? = null
}