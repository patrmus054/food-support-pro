package com.example.napomocinzynierom.data.remote

import com.google.gson.annotations.SerializedName

class AddMagazineBody {
    @SerializedName("userId")
    var userID: String? = null
    @SerializedName("magazineId")
    var magazineId: String? = null
}

class AddMagazineRespond{
    @SerializedName("message")
    var message: String? = null
}