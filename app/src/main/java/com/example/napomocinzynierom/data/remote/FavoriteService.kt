package com.example.napomocinzynierom.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoriteService {
    @POST("favorites/")
    fun addMagazines(@Body addMagazineBody: AddMagazineBody): Call<AddMagazineRespond>

    @GET("favorites/{id}")
    fun getFavorite(@Path("id")id: String): Call<List<Magazine>>
}