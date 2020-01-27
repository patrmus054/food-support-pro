package com.example.napomocinzynierom.data.remote

import com.google.gson.annotations.SerializedName

class MagazineResponde {

    @SerializedName("next")
    var next: Next? = null
    @SerializedName("magazines")
    var magazines = ArrayList<Magazine>()
}
class Next{
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("limit")
    var limit: Int = 0
}
class Magazine{

    @SerializedName("_id")
    var id: String? = null
    @SerializedName("Title1")
    var title1: String? = null
    @SerializedName("Title2")
    var title2: String? = null
    @SerializedName("issn")
    var issn: String? = null
    @SerializedName("e_issn")
    var eIssn: String? = null
    @SerializedName("Points")
    var points = ArrayList<Point>()
}

class Point{
    @SerializedName("Value")
    var value: Int = 0
}